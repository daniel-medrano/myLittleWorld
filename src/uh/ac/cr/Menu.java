package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.util.OperationController;

public class Menu {
    World people;


    OperationController operationController;

    public Menu() {
        world = new World();
        operationController = new OperationController(world);
        scanner = new Scanner(System.in);

    }
    public void verify() {
        operationController.check(world.getPersonArrayList(), world.getWoods());
    }

    public void startNewWorld(String nameWorld) {
        System.out.println("Works!");
        operationController.increaseNumOfOperations();
    }

    public void help() {
        System.out.println("The commands are: \n" +
                " exit. \n" +
                " create doctor. \n" +
                " create chef. \n" +
                " create builder. \n" +
                " create blacksmith. \n" +
                " create carpenter. \n" +
                " build house. \n" +
                " plant tree. \n" +
                " build bicycle. \n" +
                " buy bicycle.  \n" +
                " drive bicycle. \n" +
                " build car. \n" +
                " buy car. \n" +
                " drive car. \n" +
                " request loan. \n"+
                " print statistics. ");

    }

    public void createDoctor() {
        operationController.increaseNumOfOperations();
    }

    public void createChef() {
        System.out.println("Insert the ID of the chef: ");
        int chefID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the name of the chef:");
        String chefName = scanner.nextLine();
        System.out.println("Insert the last name of the chef:");
        String chefLastName = scanner.nextLine();

        // TODO REVISAR
        System.out.println("Insert the recipes of the chef:");
        String chefRecipes = scanner.nextLine();
        operationController.increaseNumOfOperations();
    }

    public void createBuilder() {
        System.out.println("Insert the ID of the builder");
        int builderID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the name of the builder");
        String builderName =scanner.nextLine();
        System.out.println("Insert the last name of the builder");
        String builderLastName = scanner.nextLine();

        world.createBuilder(builderID, builderName, builderLastName);

        operationController.increaseNumOfOperations();
    }

    public void createBlacksmith() {
        operationController.increaseNumOfOperations();
    }

    public void createCarpenter() {
        System.out.println("Insert the ID of the carpeter");
        int carpenterID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the name of the carpenter");
        String carpenterName = scanner.nextLine();
        System.out.println("Insert the last name of the carpenter");
        String carpenterLastname = scanner.nextLine();

        world.createCarpenter(carpenterID, carpenterName, carpenterLastname);

        operationController.increaseNumOfOperations();
    }
     public void buildHouse (){

     }

    public void plantTree() {
        world.plantTree();

        operationController.increaseNumOfOperations();

    }

    public void buildBicycle() {
        System.out.println("Insert the ID of the bicycle.");
        int bicycleID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is the brand of the bicycle.");
        String brandBicycle = scanner.nextLine();
        world.createBicycle(bicycleID,brandBicycle);
        operationController.increaseNumOfOperations();

    }

    public void buyBicycle() {
        Bicycle bicycle;
        int bicycleID;
        do {
            System.out.println("Choose the bike you want to buy.");
            System.out.println(world.getStringOfBicycles());
            bicycleID = scanner.nextInt();
            bicycle = world.getBicycleByID(bicycleID);
        } while (bicycle == null);

        Person owner;
        int ownerID;
        do {
            System.out.println("Choose the owner of the bike you want to buy.");
            System.out.println(world.getStringOfPeople());
            ownerID = scanner.nextInt();
            owner = world.getPersonByID(ownerID);
        } while (owner == null);

        world.buyBicycle(owner, bicycle);
        operationController.increaseNumOfOperations();

    }

    public void driveBicycle() {
        operationController.increaseNumOfOperations();

    }

    public void buildCar() {
        System.out.println("Insert the ID of the car");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is the brand of the bicycle.");
        String brandCar = scanner.nextLine();
        System.out.println("Choose the bike you want to builder");
        double priceVehicle = scanner.nextDouble();
        world.createCar(ID,brandCar);
        operationController.increaseNumOfOperations();
    }

    public void buyCar() {
        //world.buyCar();
        operationController.increaseNumOfOperations();
    }

    public void driveCar() {
        operationController.increaseNumOfOperations();
    }

    public void requestLoan() {
        operationController.increaseNumOfOperations();
    }

    public void printStatistics() {

    }
}
