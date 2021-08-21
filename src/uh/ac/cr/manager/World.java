package uh.ac.cr.manager;

import uh.ac.cr.model.*;

import java.util.ArrayList;

public class World {
    //ArrayLists that contain all the objects, these lists take advantage of polymorphism. The personArrayList can contain doctors, blacksmiths, etc.
    ArrayList<House> houseArrayList;
    ArrayList<Vehicle> vehicleArrayList;
    ArrayList<Person> personArrayList;
    private int amountDoctors;
    private int amountChefs;
    private int amountBuilders;
    private int amountBlacksmiths;
    private int amountCarpenters;
    private int amountHouses;
    private int amountBicycle;
    private int amountVehicle;
    //Woods controls the amount of trees and everything that has something to do with it.
    private Woods woods;


    public World() {
        houseArrayList = new ArrayList<>();
        vehicleArrayList = new ArrayList<>();
        personArrayList = new ArrayList<>();
        amountDoctors = 0;
        amountChefs = 0;
        amountBuilders = 0;
        amountBlacksmiths = 0;
        amountCarpenters = 0;
        amountHouses = 0;
        amountBicycle =0;
        amountVehicle = 0;
        woods = new Woods();
    }

    //Methods to create the different people according to their roles.
    public void createDoctor(int id, String name, String lastName, double income, String specialization) {
        if (woods.areThereTreesAvailable(personArrayList.size())) {
            personArrayList.add(new Doctor(id, name, lastName, income, specialization));
            amountDoctors++;
        }
    }

    public void createChef(int id, String name, String lastName, double income, ArrayList<String> recipes) {
        //TODO - validar recetas falta.
        if (woods.areThereTreesAvailable(personArrayList.size())) {
            personArrayList.add(new Chef(id, name, lastName, income, recipes));
            amountChefs++;
        }
    }

    public void createBuilder(int id, String name, String lastName, double income) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && amountBuilders < amountDoctors * 2 && amountBuilders < amountChefs * 2) {
            personArrayList.add(new Builder(id, name, lastName, income));
            amountBuilders++;
        }
    }

    public void createBlacksmith(int id, String name, String lastName) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && amountBlacksmiths < amountDoctors * 2) {
            personArrayList.add(new Blacksmith(id, name, lastName));
            amountBlacksmiths++;
        }
    }

    public void createCarpenter(int id, String name, String lastName, double income) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && woods.areThereTreesAvailable(personArrayList.size()) && amountCarpenters < amountDoctors) {
            personArrayList.add(new Carpenter(id, name, lastName, income));
            amountCarpenters++;
        }
    }



    //Methods to delete the different people according to their roles.
    public void deleteDoctor(Doctor doctor) {
        if (isPersonInList(doctor)) {
            personArrayList.remove(personArrayList.indexOf(doctor));
        }
    }

    public void deleteChef(Chef chef) {
        if (isPersonInList(chef)) {
            personArrayList.remove(personArrayList.indexOf(chef));
        }
    }

    public void deleteBuilder(Builder builder) {
        if (isPersonInList(builder)) {
            personArrayList.remove(personArrayList.indexOf(builder));
        }
    }

    public void deleteBlacksmith(Blacksmith blacksmith) {
        if (isPersonInList(blacksmith)) {
            personArrayList.remove(personArrayList.indexOf(blacksmith));
        }
    }

    public void deleteCarpenter(Carpenter carpenter) {
        if (isPersonInList(carpenter)) {
            personArrayList.remove(personArrayList.indexOf(carpenter));
        }
    }


    public void depositToDoctors(double moneyToDeposit) {
        //TODO - Si la persona que se enfermo es un doctor tambien, hay que asegurarse de que no le deposite a él tambien
        for (Person person : personArrayList) {
            if (person instanceof Doctor) {
                person.depositMoney(moneyToDeposit);
            }
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


    //Method to verify whether or not a person is in the personArrayList.
    public boolean isPersonInList(Person person) {
        return personArrayList.contains(person);
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public Woods getWoods() {
        return woods;
    }
}
