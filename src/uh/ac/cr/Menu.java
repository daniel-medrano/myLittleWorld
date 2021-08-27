package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.model.Bicycle;
import uh.ac.cr.model.Person;
import uh.ac.cr.util.FileManager;
import uh.ac.cr.util.OperationController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    World world;
    FileManager fileManager;
    OperationController operationController;

    Scanner scanner;
    boolean ready;
    String input;

    public Menu() {
        world = new World();
        fileManager = new FileManager();
        operationController = new OperationController(world);
        scanner = new Scanner(System.in);

    }

    public void save() {
        try {
            fileManager.save(world.getData());
        } catch (IOException e) {
            System.err.println("\nERROR: The operation could not be done.\n");
        }
    }

    public void verify() {
        operationController.checkNumOfOperations(world.getPersonArrayList(), world.getWoods());
        operationController.checkNumOfCreations();
    }

    public void startNewWorld(String nameWorld) {
        try {
            fileManager.createWorld(nameWorld);
        } catch (IOException e) {
            e.printStackTrace();
        }
        operationController.increaseNumOfOperations();
    }

    public void loadWorld(String nameWorld) {
        try {
            fileManager.load(nameWorld, world, operationController);
        } catch (FileNotFoundException e) {
            System.err.println("\nERROR: The world was not found.\n");
        }
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
        ready = false;
        int chefID = 0;
        do {
            try {
                System.out.println("Insert the ID of the chef. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    chefID = Integer.parseInt(input);
                    if (!world.existsPerson(chefID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a chef with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);



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
        ready = false;
        int builderID = 0;
        do {
            try {
                System.out.println("Insert the ID of the builder. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    builderID = Integer.parseInt(input);
                    if (!world.existsPerson(builderID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a builder with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

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
        ready = false;
        int blacksmithID = 0;
        do {
            try {
                System.out.println("Insert the ID of the blacksmith. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                   blacksmithID = Integer.parseInt(input);
                    if (!world.existsPerson(blacksmithID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a blacksmith with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);


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
        ready = false;
        int carpenterID = 0;
        do {
            try {
                System.out.println("Insert the ID of the carpenter. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    carpenterID = Integer.parseInt(input);
                    if (!world.existsPerson(carpenterID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a carpenter with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);


        System.out.println("Insert the name of the carpenter");
        String carpenterName = scanner.nextLine();
        if (carpenterName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        System.out.println("Insert the last name of the carpenter");
        String carpenterLastname = scanner.nextLine();
        if (carpenterLastname.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

        try {
            world.createCarpenter(carpenterID, carpenterName, carpenterLastname);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        operationController.increaseNumOfOperations();
    }
     public void buildHouse () {
        //TODO . FINISH --------------------------------------------------------------------------
         ready = false;
         int buyerID = 0;
         do {
             try {
                 System.out.println("Insert the buyer of the house.. Insert \"Cancel\" if don't want to continue.");
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
                         System.err.println("\nERROR: There is not already a person with this ID.\n");
                     }
                 }
             } catch (NumberFormatException e) {
                 System.err.println("\nERROR: The ID must be a number.\n");
             }
         } while (!ready);
     }

    public void plantTree() {
        world.plantTree();
        operationController.increaseNumOfOperations();

    }

    public void buildBicycle() {
        ready = false;
        int bicycleID = 0;
        do {
            try {
                System.out.println("Insert the ID of the bicycle. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    bicycleID = Integer.parseInt(input);
                    if (!world.existsVehicle(bicycleID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a bicycle with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        System.out.println("What is the brand of the bicycle.");
        String brandBicycle = scanner.nextLine();
        if (brandBicycle.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

        ready = false;
        int blacksmithID = 0;
        do {
            try {
                System.out.println("Insert the ID of the blacksmith. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getBlacksmiths());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    blacksmithID = Integer.parseInt(input);
                    if (world.existsPerson(blacksmithID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a blacksmith with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        try {
            world.createBicycle(bicycleID, brandBicycle, blacksmithID);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        operationController.increaseNumOfOperations();
        operationController.increaseNumOfCreations();
    }

    public void buyBicycle() {

        ready = false;
        int bicycleID = 0;
        do {
            try {
                System.out.println("Insert the ID of the bicycle. Insert \"Cancel\" if don't want to continue.");
                //TODO - It has two be getBicycles without owner.
                System.out.println(world.getBicyclesWithoutOwners());

                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    bicycleID = Integer.parseInt(input);
                    if (world.existsBicycleWithoutOwner(bicycleID)) {
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
                System.out.println("Insert the ID of the buyer. Insert \"Cancel\" if don't want to continue.");
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

        world.buyBicycle(buyerID, bicycleID);
        operationController.increaseNumOfOperations();
    }

    public void driveBicycle() {
        ready = false;
        int bicycleWithOwnerID = 0;
        do {
            try {
                System.out.println("Insert the ID of the bicycle you want to drive. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getBicyclesWithOwners());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    bicycleWithOwnerID = Integer.parseInt(input);
                    if (world.existsBicycleWithOwner(bicycleWithOwnerID)) {
                        ready = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!ready);

        world.driveBicycle(bicycleWithOwnerID);

        operationController.increaseNumOfOperations();

    }

    public void buildCar() {

        ready = false;
        int carID = 0;
        do {
            try {
                System.out.println("Insert the ID of the car. Insert \"Cancel\" if don't want to continue.");
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    carID = Integer.parseInt(input);
                    if (!world.existsVehicle(carID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is already a car with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        System.out.println("What is the brand of the car.");
        String brandCar = scanner.nextLine();
        if (brandCar.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }

        ready = false;
        int doctorID = 0;
        do {
            try {
                System.out.println("Insert the ID of the doctor. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getDoctors());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    doctorID = Integer.parseInt(input);
                    if (world.existsPerson(doctorID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is not a doctor with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        ready = false;
        int carpenterID = 0;
        do {
            try {
                System.out.println("Insert the ID of the carpenter. Insert \"Cancel\" if don't want to continue.");
                System.out.println(world.getCarpenters());
                input = scanner.next();
                scanner.nextLine();

                if (input.equals("Cancel")) {
                    System.out.println("\nDONE: The operation has been canceled.\n");
                    //Exits the operation.
                    return;
                } else {
                    carpenterID = Integer.parseInt(input);
                    if (world.existsPerson(carpenterID)) {
                        ready = true;
                    } else {
                        System.err.println("\nERROR: There is not a carpenter with this ID.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("\nERROR: The ID must be a number.\n");
            }
        } while (!ready);

        world.createCar(carID,brandCar, doctorID, carpenterID);
        // Operation counters are increased.
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
