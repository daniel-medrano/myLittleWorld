package uh.ac.cr.util;


import uh.ac.cr.model.Person;

import java.util.ArrayList;

public class OperationController {

    private int numOfOperations;

    public OperationController() {
        numOfOperations = 0;
    }

     public void increase() {
        numOfOperations++;
    }


    //2 means that the person will get sick, 1 means that the person will stay healthy.
    public void check (ArrayList<Person> personArrayList) {
        switch (numOfOperations){
            case 5:
                System.out.println("Funciono!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
                for (Person person: personArrayList) {
                    if ((int)(Math.random()*2+1) == 2) {
                        person.setSick();
                    }
                }
                break;
            case 10:
                break;
        }

    }

}
