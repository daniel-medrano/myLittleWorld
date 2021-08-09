package uh.ac.cr.manager;

import uh.ac.cr.model.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonManager {
    ArrayList<Person> personArrayList;

    public PersonManager() {
        personArrayList = new ArrayList<>();
    }

    //Methods to create the different people according to their roles.
    public void createDoctor(int id, String name, String lastName, double salary, String specialization) {
        if (woods.areThereTreesAvailable(personArrayList.size())) {
            personArrayList.add(new Doctor(id, name, lastName, salary, specialization));
            amountDoctors++;
        }
    }

    public void createChef(int id, String name, String lastName, double salary,ArrayList<String> recipes) {
        //validar recetas
        if (woods.areThereTreesAvailable(personArrayList.size())) {
            personArrayList.add(new Chef(id, name, lastName, salary, recipes));
            amountChefs++;
        }
    }

    public void createBuilder(int id, String name, String lastName, double salary) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && amountBuilders < amountDoctors * 2 && amountBuilders < amountChefs * 2) {
            personArrayList.add(new Builder(id, name, lastName, salary));
            amountBuilders++;
        }
    }

    public void createBlacksmith(int id, String name, String lastName, double salary) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && amountBlacksmiths < amountDoctors * 2) {
            personArrayList.add(new Blacksmith(id, name, lastName, salary));
            amountBlacksmiths++;
        }
    }

    public void createCarpenter(int id, String name, String lastName, double salary) {
        if (woods.areThereTreesAvailable(personArrayList.size()) && woods.areThereTreesAvailable(personArrayList.size()) && amountCarpenters < amountDoctors) {
            personArrayList.add(new Carpenter(id, name, lastName, salary));
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

    //Method to verify whether or not a person is in the personArrayList.
    public boolean isPersonInList(Person person) {
        return personArrayList.contains(person);
    }


}
