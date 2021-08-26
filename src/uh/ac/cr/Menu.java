package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.model.Bicycle;
import uh.ac.cr.model.Person;
import uh.ac.cr.util.OperationController;

import java.util.Scanner;

public class Menu {
    World world;
    Scanner scanner;


    OperationController operationController;

    public Menu() {
        world = new World();
        operationController = new OperationController(world);
        scanner = new Scanner(System.in);

    }
    public void verify() {
        operationController.check(world.getPersonArrayList(), world.getWoods());
        operationController.checkNumOfCreations();
    }

    public void startNewWorld(String nameWorld) {
        System.out.println("Works!");
        operationController.increaseNumOfOperations();
    }

    public void help() {
        System.out.println("""
                The commands are:\s
                 exit\s
                 create doctor\s
                 create chef\s
                 create builder\s
                 create blacksmith\s
                 create carpenter\s
                 build house\s
                 plant tree\s
                 build bicycle\s
                 buy bicycle \s
                 drive bicycle\s
                 build car\s
                 buy car\s
                 drive car\s
                 request loan\s
                 print statistics\s""");

    }

    public void createDoctor() {
        System.out.println("Insert the ID of the doctor:");
        int doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insert the name of the doctor:");
        String doctorName = scanner.nextLine();
        System.out.println("Insert the last name of the doctor:");
        String doctorLastName = scanner.nextLine();
        System.out.println("Insert the specialization of the doctor:");
        String doctorSpecialization = scanner.nextLine();
        if (doctorSpecialization.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        try {
            //TODO - Delete the verification of the ID from createDoctor, because that is already done when the ID is asked.
            world.createDoctor(doctorID, doctorName, doctorLastName, doctorSpecialization);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

        //world.createChef(chefID,chefName,chefLastName,chefRecipes);


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
        System.out.println("Insert the ID of the blacksmith:");
        int blacksmithID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insert the name of the blacksmith:");
        String blacksmithName = scanner.nextLine();
        System.out.println("Insert the last name of the blacksmith:");
        String blacksmithLastName = scanner.nextLine();

        try {
            world.createBlacksmith(blacksmithID, blacksmithName, blacksmithLastName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

        try {
            world.createCarpenter(carpenterID, carpenterName, carpenterLastname);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        operationController.increaseNumOfOperations();
    }
     public void buildHouse (){
        //TODO - Test method
        int buyerID;
        do {
            System.out.println("Select the buyer of the house. ");
            System.out.println(world.getPeople());
            buyerID = scanner.nextInt();
        } while (world.getPersonByID(buyerID) == null);


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
        operationController.increaseNumOfCreations();

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
            System.out.println(world.getPeople());
            ownerID = scanner.nextInt();
            owner = world.getPersonByID(ownerID);
        } while (owner == null);


        world.buyBicycle(owner, bicycle);
        operationController.increaseNumOfOperations();

    }

    public void driveBicycle() {
        System.out.println("Choose the bicycle you want to drive.");
        System.out.println(world.getBicyclesWithOwners());
        int bicycleWithOwners = scanner.nextInt();
        scanner.nextLine();
        try {
            world.driveBicycle(bicycleWithOwners);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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
        operationController.increaseNumOfCreations();
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
