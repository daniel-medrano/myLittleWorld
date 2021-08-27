package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.model.Bicycle;
import uh.ac.cr.model.Person;
import uh.ac.cr.util.OperationController;

import java.util.Scanner;

public class Menu {
    World world;
    Scanner scanner;
    boolean ready;
    String input;


    OperationController operationController;

    public Menu() {
        world = new World();
        operationController = new OperationController(world);
        scanner = new Scanner(System.in);

    }
    public void verify() {
        operationController.checkNumOfOperations(world.getPersonArrayList(), world.getWoods());
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
        ready = false;
        int doctorID = 0;
        do {
            try {
                System.out.println("Insert the ID of the doctor. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    doctorID = Integer.parseInt(input);
                    if (!world.existsPerson(doctorID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a doctor with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        System.out.println("Insert the name of the doctor. Insert \"Cancel\" if don't want to continue.");
        String doctorName = scanner.nextLine();
        if (doctorName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the last name of the doctor. Insert \"Cancel\" if don't want to continue.");
        String doctorLastName = scanner.nextLine();
        if (doctorLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the specialization of the doctor. Insert \"Cancel\" if don't want to continue.");
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
        if (chefName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the last name of the chef:");
        String chefLastName = scanner.nextLine();
        if (chefLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

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
        if (builderName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the last name of the builder");
        String builderLastName = scanner.nextLine();
        if (builderLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

        try {
            world.createBuilder(builderID, builderName, builderLastName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        operationController.increaseNumOfOperations();
    }

    public void createBlacksmith() {

        System.out.println("Insert the ID of the blacksmith:");
        int blacksmithID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insert the name of the blacksmith:");
        String blacksmithName = scanner.nextLine();
        if (blacksmithName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the last name of the blacksmith:");
        String blacksmithLastName = scanner.nextLine();
        if (blacksmithLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

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
        try {
            world.createBicycle(bicycleID, brandBicycle, blacksmithID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        operationController.increaseNumOfOperations();
        operationController.increaseNumOfCreations();

    }

    public void buyBicycle() {
        Bicycle bicycle;
        int bicycleID;
        do {
            System.out.println("Choose the bicycle you want to buy.");
            System.out.println(world.getBicycles());
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
        System.out.println("What is the brand of the car.");
        String brandCar = scanner.nextLine();
        world.createCar(ID,brandCar);
        operationController.increaseNumOfOperations();
        operationController.increaseNumOfCreations();

    }

    public void buyCar() {
        ready = false;
        int carID = 0;
        do {
            try {
                System.out.println("Insert the ID of the car. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getCarsWithoutOwners());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    carID = Integer.parseInt(input);
                    if (world.existsCarWithoutOwner(carID)) {
                        ready = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!ready);

        ready = false;
        int buyerID = 0;
        do {
            try {
                System.out.println("Insert the ID of the car's buyer. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getPeople());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    buyerID = Integer.parseInt(input);
                    if (world.existsPerson(buyerID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is not a buyer with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

         world.buyCar(buyerID, carID);
        operationController.increaseNumOfOperations();
    }


    public void driveCar() {
        ready = false;
        int carWithOwnerID = 0;
        do {
            try {
                System.out.println("Insert the ID of the car you want to drive. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getCarsWithOwners());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    carWithOwnerID = Integer.parseInt(input);
                    if (world.existsCarWithoutOwner(carWithOwnerID)) {
                        ready = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!ready);

        world.driveCar(carWithOwnerID);
        operationController.increaseNumOfOperations();
    }

    public void requestLoan() {
        operationController.increaseNumOfOperations();
    }

    public void printStatistics() {

    }
}
