package uh.ac.cr;

import uh.ac.cr.manager.PersonManager;
import uh.ac.cr.model.Person;
import uh.ac.cr.util.OperationController;

import java.util.ArrayList;

public class Menu {
    PersonManager people;


    OperationController operationController;

    public Menu() {
        operationController = new OperationController();
        people = new PersonManager();
    }
    public void verify() {
        operationController.check(people.getPersonArrayList());
    }

    public void startNewWorld(String nameWorld) {
        System.out.println("Works!");
        operationController.increase();
    }

    public void help() {
        System.out.println("");
    }

    public void createDoctor() {
        operationController.increase();
    }

    public void createChef() {
        operationController.increase();
    }

    public void createBuilder() {
        operationController.increase();
    }

    public void createBlacksmith() {
        operationController.increase();
    }

    public void createCarpenter() {
        operationController.increase();
    }

    public void plantTree() {
        operationController.increase();

    }

    public void buildBicycle() {
        operationController.increase();

    }

    public void buyBicycle() {
        operationController.increase();

    }

    public void driveBicycle() {
        operationController.increase();
    }

    public void buildCar() {
        operationController.increase();
    }

    public void buyCar() {
        operationController.increase();
    }

    public void driveCar() {
        operationController.increase();
    }

    public void requestLoan() {
        operationController.increase();
    }

    public void printStatistics() {

    }
}
