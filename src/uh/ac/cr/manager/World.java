package uh.ac.cr.manager;

import uh.ac.cr.model.*;
import uh.ac.cr.util.OperationController;

import java.util.ArrayList;

public class World {
    String worldName;
    //ArrayLists that contain all the objects, these lists take advantage of polymorphism. The personArrayList can contain doctors, blacksmiths, etc.
    ArrayList<House> houseArrayList;
    ArrayList<Vehicle> vehicleArrayList;
    ArrayList<Person> personArrayList;
    //Counters are initialized to control the amount of objects.
    private int amountPeople;
    private int amountDoctors;
    private int amountChefs;
    private int amountBuilders;
    private int amountBlacksmiths;
    private int amountCarpenters;
    private int amountHouses;
    private int amountBicycle;
    private int amountVehicle;
    private int amountCars;
    //Woods controls the amount of trees and everything that has something to do with it.
    private Woods woods;
    private Government government;
    private OperationController operationController;


    public World() {
        houseArrayList = new ArrayList<>();
        vehicleArrayList = new ArrayList<>();
        personArrayList = new ArrayList<>();
        amountPeople = 0;
        amountDoctors = 0;
        amountChefs = 0;
        amountBuilders = 0;
        amountBlacksmiths = 0;
        amountCarpenters = 0;
        amountHouses = 0;
        amountBicycle = 0;
        amountVehicle = 0;
        amountCars = 0;
        woods = new Woods();
        government = new Government();
    }

    //PEOPLE
    //Methods to create the different people according to their roles.
    public boolean createDoctor(int id, String name, String lastName, String specialization) {
        personArrayList.add(new Doctor(id, name, lastName, specialization));
        amountPeople++;
        amountDoctors++;
        return true;
    }

    public boolean createChef(int id, String name, String lastName, ArrayList<String> recipes) {
        //TODO - validar recetas falta.
        personArrayList.add(new Chef(id, name, lastName, recipes));
        amountPeople++;
        amountChefs++;
        return true;
    }

    public boolean createBuilder(int id, String name, String lastName) {
        personArrayList.add(new Builder(id, name.trim(), lastName.trim()));
        amountPeople++;
        amountBuilders++;
        return true;
    }

    public boolean createBlacksmith(int id, String name, String lastName) {
        //For each blacksmith there must be 0.5 doctors, this means that in order to create a blacksmith you must create two doctors.
        personArrayList.add(new Blacksmith(id, name.trim(), lastName.trim()));
        amountPeople++;
        amountBlacksmiths++;
        return true;
    }

    public boolean createCarpenter(int id, String name, String lastName)  {
        personArrayList.add(new Carpenter(id, name.trim(), lastName.trim()));
        amountPeople++;
        amountCarpenters++;
        return true;
    }
    //BELONGINGS
    //Methods to create the vehicles and the house.
    //TODO - Validate jf the person has the money in menu.

    public void createHouse(int buyerID, Person[] houseCreators) {
        //TODO - move this to menu.
        if (amountCarpenters >= 2 && amountBuilders >= 3 && amountBlacksmiths >= 1) {
            Person buyer = getPersonByID(buyerID);
            buyer.withdrawMoney(27);
            buyer.increaseHouses();
            //Pays the amount of money to each person
            for (Person person : houseCreators) {
                if (person instanceof Carpenter) {
                    person.depositMoney(4);
                } else if (person instanceof Builder) {
                    person.depositMoney(2);
                } else if (person instanceof Blacksmith) {
                    person.depositMoney(3);
                }
            }
            houseArrayList.add(new House(buyer));
            //TODO -  se pagan los impuestos al gobierno por la creacion de la casa
            government.depositTaxes(10);
            amountHouses++;
        }
    }

    public void createBicycle(int bicycleID, String brand, int blacksmithID) throws Exception {
        //TODO - Manejar excepciones.
        if (amountBlacksmiths >= 1) {
            vehicleArrayList.add(new Bicycle(bicycleID, brand.trim(), getPersonByID(blacksmithID)));
            amountVehicle++;
            amountBicycle++;
        } else {
            if (amountBlacksmiths == 0) {
                throw new Exception("\nERROR: You must create a blacksmith to be able to build the bicycle.\n");
            }
        }
    }

    public void createCar(int ID, String brand, int doctorID, int carpenterID) {
        Person[] creators = new Person[2];
        creators[0] = getPersonByID(doctorID);
        creators[1] = getPersonByID(carpenterID);
        vehicleArrayList.add(new Car(ID, brand.trim(), creators));
        //TODO - SE PAGAN LOS IMPUESTOS AL GOBIERNO POR LA CREACION DEL CARRO
        government.depositTaxes(5);
        amountVehicle++;
        amountCars++;

    }

    public String getPeople() {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
        }
        return stringOfPeople;
    }

    public String getPeopleStatistics() {
        String peopleStatistics = "";
        for (Person person : personArrayList){
            peopleStatistics = peopleStatistics + person.getPersonStatistics() + "\n";
        }
        return peopleStatistics;
    }

    public String getDoctors() {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            if (person instanceof Doctor) {
                stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
            }
        }
        return stringOfPeople;
    }

    public String getCarpenters() {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            if (person instanceof Carpenter) {
                stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
            }
        }
        return stringOfPeople;
    }

    public String getCarpenters(Person carpenter) {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            if (person instanceof Carpenter && person != carpenter) {
                stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
            }
        }
        return stringOfPeople;
    }

    public String getBuilders() {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            if (person instanceof Builder ) {
                stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
            }
        }
        return stringOfPeople;
    }

    public String getBuilders(Person... builders) {
        //List with builder that will be excluded from the string that will have the list of them.
        Person[] buildersExcluded = builders;
        String stringOfPeople = "";
        boolean ignore;
        //It iterates through the list looking for builders.
        for (Person person : personArrayList) {
            //The var ignore is set to false for every person.
            ignore = false;
            //Verifies if it is a builder.
            if (person instanceof Builder ) {
                //Iterates through the builder that should be excluded.
                for (Person builder : buildersExcluded) {
                    //If there is a match with one of the people that should be excluded, the var ignore is set to true.
                    if (person == builder) {
                        ignore = true;
                    }
                }
                //If ignore is true, the builder won't be added.
                if (!ignore) {
                    stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
                }
            }
        }
        return stringOfPeople;
    }


    public String getBlacksmiths() {
        String stringOfPeople = "";
        for (Person person : personArrayList) {
            if (person instanceof Blacksmith) {
                stringOfPeople = stringOfPeople + person.getPersonInfo() + "\n";
            }
        }
        return stringOfPeople;
    }


    public String getBicycles() {
        String stringOfBicycles = "";
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Bicycle) {
                stringOfBicycles = stringOfBicycles + vehicle.getBicycleInfoToBuy() + "\n";
            }
        }
        return stringOfBicycles;
    }


    public String getBicyclesWithOwners() {
        String bicycleWithOwners = "";
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Bicycle) {
                if (vehicle.hasOwner()) {
                    bicycleWithOwners = bicycleWithOwners + vehicle.getBicycleInfo() + "\n";
                }
            }
        }
        return bicycleWithOwners;
    }

    public String getBicyclesWithoutOwners() {
        String bicycleWithoutOwners = "";
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Bicycle) {
                if (!vehicle.hasOwner()) {
                    bicycleWithoutOwners = bicycleWithoutOwners + vehicle.getBicycleInfoToBuy() + "\n";
                }
            }
        }
        return bicycleWithoutOwners;
    }
    public String getCarsWithOwners() {
        String carWithOwners = "";
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Car) {
                if (vehicle.hasOwner()) {
                    carWithOwners = carWithOwners + vehicle.getBicycleInfo() + "\n";
                }
            }
        }
        return carWithOwners;
    }
    public String getCarsWithoutOwners() {
        String carWithoutOwners = "";
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Car) {
                if (vehicle.hasOwner()) {
                    carWithoutOwners = carWithoutOwners + vehicle.getBicycleInfo() + "\n";
                }
            }
        }
        return carWithoutOwners;
    }

    public Person getPersonByID(int personID) {
        for (Person person : personArrayList) {
            if (person.getId() == personID) {
                return person;
            }
        }
        return null;
    }

    public Vehicle getVehicleByID(int vehicleID) {
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle.getID() == vehicleID) {
                return vehicle;
            }
        }
        return null;
    }

    public Bicycle getBicycleByID(int bicycleID) {
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Bicycle) {
                if (vehicle.getID() == bicycleID) {
                    return (Bicycle) vehicle;
                }
            }
        }
        return null;
    }
    //TODO - IMPRIMIR ESTADISTICAS DEL MUNDO
    public String getStatistics() {
        return "\t\t\t\"World's Name:" + worldName +
                getPeopleStatistics() +
                "Trees: " + woods.getTrees() + "\n" +
                "Government Income: " + government.getIncome() + "\n" +
                // TODO --personas muertas
                // TODO DIENRO TOTAL DEL MMUNDO
                "Total Objects: " + getTotalObjects() + "\n" +
                "Total Operations: " + operationController.getNumOfOperations();

    }

    public int getTotalObjects(){
        return amountVehicle + amountHouses + amountPeople ;

    }


    //Methods to delete the different people according to their roles.
    public void deletePerson(Person person) {
        if (isPersonInList(person)) {
            personArrayList.remove(person);
        }
    }



    //Methods to buy the vehicles
    //TODO

    public void buyBicycle(int buyerID, int bicycleID) {
        //TODO - Revisar si es mejor verificar si tiene el dinero en el mismo metodo o en la clase menu.
        Person buyer = getPersonByID(buyerID);
        Bicycle bicycle = getBicycleByID(bicycleID);

        if (buyer.hasMoney(bicycle.getPriceVehicle())) {
            buyer.withdrawMoney(bicycle.getPriceVehicle());
            buyer.increaseCars();
            bicycle.setOwner(buyer);
        }
    }

    public void buyCar(int buyerID, int carID) {
        Person buyer = getPersonByID(buyerID);
        Car car = (Car) getVehicleByID(carID);

        if (buyer.hasMoney(car.getPriceVehicle())) {
            buyer.withdrawMoney(car.getPriceVehicle());
            buyer.increaseCars();
            car.setOwner(buyer);
        }
    }

    //Methods to drive the vehicles


    public void driveBicycle(int bicycleID) {
        //Method that throws Exceptions.
        getBicycleByID(bicycleID).drive();

    }

    public void driveCar(int carID) {
        getVehicleByID(carID).drive();
        woods.decreaseTrees(3);
    }

    //MANAGE MONEY METHODS
    public void depositToDoctors(double moneyToDeposit) {
        //TODO - Si la persona que se enfermo es un doctor tambien, hay que asegurarse de que no le deposite a él tambien
        for (Person person : personArrayList) {
            if (person instanceof Doctor) {
                person.depositMoney(moneyToDeposit);
            }
        }
    }

    public void depositToAllPeople(int moneyToDeposit) {
        for (Person person : personArrayList) {
            person.depositMoney(moneyToDeposit);
        }
    }

    public void withdrawToDoctors(double moneyToWithdraw) {
        //TODO - Si la persona que se murio es un doctor tambien, hay que asegurarse de que no le quite a él tambien, porque ya se murio
        for (Person person : personArrayList) {
            if (person instanceof Doctor) {
                person.withdrawMoney(moneyToWithdraw);
            }
        }
    }

    public boolean existsPerson(int id) {
        return getPersonByID(id) != null;
    }

    public boolean existsVehicle(int id) {
        return getVehicleByID(id) != null;
    }

    public boolean existsBicycleWithOwner(int bicycleID) throws Exception {
        Bicycle bicycle = getBicycleByID(bicycleID);
        if (bicycle == null) {
            throw new Exception("\nERROR: There is not a bicycle with this ID.\n");
        } else if (!bicycle.hasOwner()) {
            throw new Exception("\nERROR: This bicycle does not have an owner and therefore it is not in the list. \n");
        }
        return bicycle.hasOwner();
    }

    public boolean existsBicycleWithoutOwner(int bicycleID) throws Exception {
        Bicycle bicycle = getBicycleByID(bicycleID);
        if (bicycle == null) {
            throw new Exception("\nERROR: There is not a bicycle with this ID.\n");
        } else if (bicycle.hasOwner()) {
            throw new Exception("\nERROR: This bicycle already has an owner and therefore it is not in the list. \n");
        }
        return !bicycle.hasOwner();
    }
//TODO ..........................................................................................
    public boolean existsCarWithoutOwner(int carID) throws Exception {
        Car car = (Car) getVehicleByID(carID);
        if (car == null) {
            throw new Exception("\nERROR: There is not a car with this ID.\n");
        } else if (car.hasOwner()) {
            throw new Exception("\nERROR: This car already has an owner and therefore it is not in the list. \n");
        }
        return !car.hasOwner();
    }

    //Method to verify whether or not a person is in the personArrayList.
    public boolean isPersonInList(Person person) {
        return personArrayList.contains(person);
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void plantTree() {
        if (government.withdrawMoney(0.5)) {
            woods.increaseTrees();
        }
    }

    public void setWorldName(String name) {
        this.worldName =name;
    }

    public Woods getWoods() {
        return woods;
    }

    public int getTreesAvailable() {
        return woods.getTreesAvailable(personArrayList.size());
    }

    public boolean areThereTreesAvailable() {
        return woods.areThereTreesAvailable(personArrayList.size());
    }

    public void setOperationController(OperationController operationController) {
        this.operationController = operationController;
    }

    //METHODS.
    public boolean isBuilderConditionMet() throws Exception {
        if (!(amountBuilders < amountChefs * 2) && !(amountBuilders < amountDoctors * 2)) {
            throw new Exception("\nERROR: You must create a chef and a doctor to create a builder.\n");

        } else if (!(amountBuilders < amountChefs * 2)) {
            throw new Exception("\nERROR: You must create a chef to create a builder.\n");

        } else if (!(amountBuilders < amountDoctors * 2)) {
            throw new Exception("\nERROR: You must create a doctor to create a builder.\n");

        } else {
            return true;
        }
    }

    public boolean isCarpenterConditionMet() throws Exception {
        if (!(amountCarpenters < amountDoctors)) {
            throw new Exception("\nERROR: You must create another doctor in order to create another carpenter.\n");
        } else {
            return true;
        }
    }

    public boolean isBlacksmithConditionMet() throws Exception {
        if (!(amountBlacksmiths < amountDoctors * 2)) {
            throw new Exception("\nERROR: You must create a doctor in order to create two blacksmiths more.\n");
        } else {
            return true;
        }
    }

    public String getData() {
        return "\"Data\": [\n" +
                getGovernmentString() + "\n" +
                getPeopleString() + "\n" + //TODO. It is missing a coma.
                getVehiclesString() + "\n" +
                getHousesString() + "\n" +
                getWoodsString() + "\n" +
                getOperationControllerString() +
                "\n]";
    }

    public String getGovernmentString() {
        return "";
    }

    public String getPeopleString() {
        if (personArrayList.size() == 0) {
            return "";
        }
        String peopleString = "";
        for (int i = 0; i < personArrayList.size(); i++) {
            Person person = personArrayList.get(i);
            if (i == personArrayList.size() - 1) {
                peopleString = peopleString + person.getPerson() + "\n";
            } else {
                peopleString = peopleString + person.getPerson() + ",\n";
            }
        }
        return "\t\"personArrayList\": [\n" +
                peopleString +
                "\t]";
    }

    public String getVehiclesString() {
        if (vehicleArrayList.size() == 0) {
            return "";
        }
        String vehiclesString = "";
        for (int i = 0; i < vehicleArrayList.size(); i++) {
            Vehicle vehicle = vehicleArrayList.get(i);
            if (i == vehicleArrayList.size() - 1) {
                vehiclesString = vehiclesString + vehicle.getVehicle() + "\n";
            } else {
                vehiclesString = vehiclesString + vehicle.getVehicle() + ",\n";
            }
        }
        return "\t\"vehicleArrayList\": [\n" +
                vehiclesString +
                "\t]";
    }

    public String getHousesString() {
        return "";
    }

    public String getWoodsString() {
        return "";
    }

    public String getOperationControllerString() {
        return "";
    }
}