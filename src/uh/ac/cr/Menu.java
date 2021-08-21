package uh.ac.cr;

import uh.ac.cr.manager.World;
import uh.ac.cr.util.OperationController;

public class Menu {
    World people;


    OperationController operationController;

    public Menu() {
        people = new World();
        operationController = new OperationController(people);

    }
    public void verify() {
        operationController.check(people.getPersonArrayList(), people.getWoods());
    }

    public void startNewWorld(String nameWorld) {
        System.out.println("Works!");
        operationController.increaseNumOfOperations();
    }

    public void help() {
        System.out.println("");
    }

    public void createDoctor() {
        operationController.increaseNumOfOperations();
    }

    public void createChef() {
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
