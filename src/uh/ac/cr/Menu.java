package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.model.Bicycle;
import uh.ac.cr.model.Carpenter;
import uh.ac.cr.model.Person;
import uh.ac.cr.util.FileManager;
import uh.ac.cr.util.OperationController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

        world.setOperationController(operationController);

    }

    public void displayData() {
        System.out.println("Operations performed: " + operationController.getNumOfOperations());
    }

    public void save() {
        try {
            fileManager.save(world.getData());
        } catch (IOException e) {
            System.err.println("\nERROR: The operation could not be done.\n");
        }
    }

    public void increaseOperations() {
        operationController.increaseNumOfOperations();
        operationController.checkNumOfOperations(world.getPersonArrayList(), world.getWoods());
        operationController.checkNumOfCreations();
    }

    public void startNewWorld(String nameWorld) {
        try {
            fileManager.createWorld(nameWorld);
            world.setWorldName(nameWorld);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadWorld(String nameWorld) {
        try {
            fileManager.load(nameWorld, world, operationController);
            world.setWorldName(nameWorld);
        } catch (FileNotFoundException e) {
            System.err.println("\nERROR: The world was not found.\n");
        }
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
        if (!world.areThereTreesAvailable()) {
            System.err.println("\nERROR: There are not enough trees per person. There must be at least " + world.getTreesAvailable() + " more.\n");
            return;
        }
        //Asks for the ID.
        ready = false;
        int doctorID = 0;
        do {
            System.out.println("Insert the ID of the doctor. Insert \"Cancel\" if don't want to continue.");
            input = scanner.next();
            scanner.nextLine();

            if (input.equals("Cancel")) {
                System.out.println("\nDONE: The operation has been canceled.\n");
                //Exits the operation.
                return;
            }
            ready = verifyPersonID(input);
            if (ready) {
                doctorID = Integer.parseInt(input);
            }
        } while (!ready);
        //Asks for the name.
        System.out.println("Insert the name of the doctor. Insert \"Cancel\" if don't want to continue.");
        String doctorName = scanner.nextLine();
        if (doctorName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        //Asks for the last name.
        System.out.println("Insert the last name of the doctor. Insert \"Cancel\" if don't want to continue.");
        String doctorLastName = scanner.nextLine();
        if (doctorLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        //Asks for the specialization.
        System.out.println("Insert the specialization of the doctor. Insert \"Cancel\" if don't want to continue.");
        String doctorSpecialization = scanner.nextLine();
        if (doctorSpecialization.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        //Creates the doctor.
        if (world.createDoctor(doctorID, doctorName, doctorLastName, doctorSpecialization)) {
            System.out.println("\nDONE: The doctor has been created.\n");
            increaseOperations();
        }
    }

    public void createChef() {

        if (!world.areThereTreesAvailable()) {
            System.err.println("\nERROR: There are not enough trees per person. There must be at least " + world.getTreesAvailable() + " more.\n");
            return;
        }
        //Asks for the ID.
        ready = false;
        int chefID = 0;
        do {
            System.out.println("Insert the ID of the chef. Insert \"Cancel\" if don't want to continue.");
            input = scanner.next();
            scanner.nextLine();

            if (input.equals("Cancel")) {
                System.out.println("\nDONE: The operation has been canceled.\n");
                //Exits the operation.
                return;
            }
            ready = verifyPersonID(input);
            if (ready) {
                chefID = Integer.parseInt(input);
            }
        } while (!ready);
        //Asks for the name.
        System.out.println("Insert the name of the chef. Insert \"Cancel\" if don't want to continue.");
        String chefName = scanner.nextLine();
        if (chefName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        //Asks for the last name.
        System.out.println("Insert the last name of the chef. Insert \"Cancel\" if don't want to continue.");
        String chefLastName = scanner.nextLine();
        if (chefLastName.equals("Cancel")) {
            System.out.println("\nDONE: The operation has been canceled.\n");
            //Exits the operation.
            return;
        }
        //Asks for the recipes.
        ArrayList<String> recipes = new ArrayList<>();
        System.out.println("Insert 10 recipes of the chef or less. Insert \"Ready\" if you are done.");
        int recipesCounter = 1;
        do {
            System.out.println("Insert the recipe #" + recipesCounter + ": ");
            input = scanner.nextLine();
            recipes.add(input);
            recipesCounter++;
        } while (!input.equals("Ready") && recipes.size() <= 10);
        //Creates the chef.
        if (world.createChef(chefID,chefName,chefLastName, recipes)) {
            System.out.println("\nDONE: The chef has been created.\n");
            increaseOperations();
        }
    }

    public void createBuilder() {

        if (!world.areThereTreesAvailable()) {
            System.err.println("\nERROR: There are not enough trees per person. There must be at least " + world.getTreesAvailable() + " more.\n");
            return;
        } else if (!isBuilderConditionMet()) {
            return;
        }

        ready = false;
        int builderID = 0;
        do {
            System.out.println("Insert the ID of the builder. Insert \"Cancel\" if don't want to continue.");
            input = scanner.next();
            scanner.nextLine();

            if (input.equals("Cancel")) {
                System.out.println("\nDONE: The operation has been canceled.\n");
                //Exits the operation.
                return;
            }
            ready = verifyPersonID(input);
            if (ready) {
                builderID = Integer.parseInt(input);
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

        if (world.createBuilder(builderID, builderName, builderLastName)) {
            System.out.println("\nDONE: The builder has been created.\n");
            increaseOperations();
        }
    }

    public void createBlacksmith() {

        if (!world.areThereTreesAvailable()) {
            System.err.println("\nERROR: There are not enough trees per person. There must be at least " + world.getTreesAvailable() + " more.\n");
            return;
        } else if (!isBlacksmithConditionMet()) {
            return;
        }

        ready = false;
        int blacksmithID = 0;
        do {
            System.out.println("Insert the ID of the blacksmith. Insert \"Cancel\" if don't want to continue.");
            input = scanner.next();
            scanner.nextLine();

            if (input.equals("Cancel")) {
                System.out.println("\nDONE: The operation has been canceled.\n");
                //Exits the operation.
                return;
            }
            ready = verifyPersonID(input);
            if (ready) {
                blacksmithID = Integer.parseInt(input);
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

        if (world.createBlacksmith(blacksmithID, blacksmithName, blacksmithLastName)) {
            System.out.println("\nDONE: The blacksmith has been created.\n");
            increaseOperations();
        }
    }

    public void createCarpenter() {

        if (!world.areThereTreesAvailable()) {
            System.err.println("\nERROR: There are not enough trees per person. There must be at least " + world.getTreesAvailable() + " more.\n");
            return;
        } else if (!isCarpenterConditionMet()) {
            return;
        }

        ready = false;
        int carpenterID = 0;
        do {
            System.out.println("Insert the ID of the carpenter. Insert \"Cancel\" if don't want to continue.");
            input = scanner.next();
            scanner.nextLine();

            if (input.equals("Cancel")) {
                System.out.println("\nDONE: The operation has been canceled.\n");
                //Exits the operation.
                return;
            }
            ready = verifyPersonID(input);
            if (ready) {
                carpenterID = Integer.parseInt(input);
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

        if (world.createCarpenter(carpenterID, carpenterName, carpenterLastname)) {
            System.out.println("\nDONE: The carpenter has been created.\n");
            increaseOperations();
        }

    }
     public void buildHouse () {
        //2 carpenters, 3 builder, 1 blacksmith
        //TODO . FINISH --------------------------------------------------------------------------
         ready = false;
         int buyerID = 0;
         do {
             System.out.println("Insert the buyer of the house. Insert \"Cancel\" if don't want to continue.");
             System.out.println(world.getPeople());
             input = scanner.next();
             scanner.nextLine();

             if (input.equals("Cancel")) {
                 System.out.println("\nDONE: The operation has been canceled.\n");
                 //Exits the operation.
                 return;
             }

             ready = verifyPersonID(input);
             if (ready) {
                 buyerID = Integer.parseInt(input);
             }
         } while (!ready);
        //TODO. TEST THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
         Person[] creators = new Person[6];
         ready = false;
         int carpenterID = 0;
         do {
             try {
                 if (creators[0] == null) {
                     System.out.println("Insert the ID of the first carpenter. Insert \"Cancel\" if don't want to continue.");
                     System.out.println(world.getCarpenters());
                 } else {
                     System.out.println("Insert the ID of the second carpenter. Insert \"Cancel\" if don't want to continue.");
                     System.out.println(world.getCarpenters(creators[0]));
                 }
                 input = scanner.next();
                 scanner.nextLine();

                 if (input.equals("Cancel")) {
                     System.out.println("\nDONE: The operation has been canceled.\n");
                     //Exits the operation.
                     return;
                 } else {
                     carpenterID = Integer.parseInt(input);
                     if (world.existsPerson(carpenterID)) {
                         if (creators[0] == null) {
                             creators[0] = world.getPersonByID(carpenterID);
                         } else if (creators[1] == null) {
                             Person person = world.getPersonByID(carpenterID);
                             if (person != creators[0])
                                creators[1] = person;
                             else
                                 System.err.println("\nERROR: You already chose a carpenter with this ID.");
                         }
                         //If the carpenters exist and the user selected the two of them already.
                         if (creators[0] != null && creators[1] != null) {
                             ready = true;
                         }
                     } else {
                         System.err.println("\nERROR: There is not a carpenter with this ID.\n");
                     }
                 }
             } catch (NumberFormatException e) {
                 System.err.println("\nERROR: The ID must be a number.\n");
             }
         } while (!ready);


            // TODO elegir los herreros
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
             }

             ready = verifyPersonID(input);

             if (ready) {
                 blacksmithID = Integer.parseInt(input);
                 creators[2] = world.getPersonByID(blacksmithID);
             }
         } while (!ready);

         // TODO elegir el albañil
         ready = false;
         int builderID = 0;
         do {
             try {
                 if (creators[3] == null) {
                     System.out.println("Insert the ID of the first builder. Insert \"Cancel\" if don't want to continue.");
                     System.out.println(world.getBuilders());
                 } else if (creators[4] == null){
                     System.out.println("Insert the ID of the second builder. Insert \"Cancel\" if don't want to continue.");
                     System.out.println(world.getBuilders(creators[3]));
                 } else {
                     System.out.println("Insert the ID of the third builder. Insert \"Cancel\" if don't want to continue.");
                     System.out.println(world.getBuilders(creators[3], creators[4]));
                 }
                 input = scanner.next();
                 scanner.nextLine();

                 if (input.equals("Cancel")) {
                     System.out.println("\nDONE: The operation has been canceled.\n");
                     //Exits the operation.
                     return;
                 } else {
                     builderID = Integer.parseInt(input);
                     if (world.existsPerson(builderID)) {
                         Person person = world.getPersonByID(builderID);
                         if (creators[3] == null) {
                             creators[3] = world.getPersonByID(builderID);
                         } else if (creators[4] == null) {
                             if (person != creators[3])
                                creators[4] = person;
                             else
                                 System.err.println("\nERROR: You already chose a builder with this ID.");
                         } else if (creators[5] == null) {
                             if (person != creators[4] && person != creators[3])
                                 creators[5] = person;
                             else
                                 System.err.println("\nERROR: You already chose a builder with this ID.");
                         }

                         if (creators[3] != null && creators[4] != null && creators[5] != null) {
                             ready = true;
                         }
                     } else {
                         System.err.println("\nERROR: There is not a builder with this ID.\n");
                     }
                 }
             } catch (NumberFormatException e) {
                 System.err.println("\nERROR: The ID must be a number.\n");
             }
         } while (!ready);


         world.createHouse(buyerID, creators);
         increaseOperations();
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
            increaseOperations();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void buyBicycle() {

        ready = false;
        int bicycleID = 0;
        do {
            try {
                System.out.println("Insert the ID of the bicycle. Insert \"Cancel\" if don't want to continue.");
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
        increaseOperations();
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

        increaseOperations();

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
        increaseOperations();
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
        increaseOperations();
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
        increaseOperations();
    }

    public void requestLoan() {
        increaseOperations();
    }

    public void printStatistics() {
        System.out.println(world.getStatistics());

    }


    public boolean verifyPersonID(String input) {
        int ID;
        try {
            ID = Integer.parseInt(input);
            if (!world.existsPerson(ID)) {
                return true;
            } else {
                System.err.println("\nERROR: There is already a person with this ID.\n");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("\nERROR: The ID must be a number.\n");
            return false;
        }
    }

    public boolean isBuilderConditionMet() {
        try {
            return world.isBuilderConditionMet();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean isCarpenterConditionMet() {
        try {
            return world.isCarpenterConditionMet();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean isBlacksmithConditionMet() {
        try {
            return world.isBlacksmithConditionMet();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
