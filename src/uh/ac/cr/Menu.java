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
        operationController.increaseNumOfOperations();
    }

    public void createBlacksmith() {
        operationController.increaseNumOfOperations();
    }

    public void createCarpenter() {
        operationController.increaseNumOfOperations();
    }
     public void buildHouse (){

     }

    public void plantTree() {
        operationController.increaseNumOfOperations();

    }

    public void buildBicycle() {
        operationController.increaseNumOfOperations();

    }

    public void buyBicycle() {
        operationController.increaseNumOfOperations();

    }

    public void driveBicycle() {
        operationController.increaseNumOfOperations();
    }

    public void buildCar() {
        operationController.increaseNumOfOperations();
    }

    public void buyCar() {
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
