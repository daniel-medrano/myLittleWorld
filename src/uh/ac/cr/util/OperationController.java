package uh.ac.cr.util;


import uh.ac.cr.model.Person;

import java.util.ArrayList;

public class OperationController {

    private int numOfOperations;

    public OperationController() {
        numOfOperations = 0;
    }

    public void increaseNumOfCreations() {
        numOfCreations++;
    }

    public void increaseNumOfOperations() {
        numOfOperations++;
    }


    //2 means that the person will get sick, 1 means that the person will stay healthy.
    public void check(ArrayList<Person> personArrayList, Woods woods) {

        if (numOfOperations % 5 == 0) {

            boolean gotSick;
            boolean died;

            for (Person person : personArrayList) {
                gotSick = false;
                died = false;
                //If the person gets sick for the first time, the var gotSick will be set to true, if the person was already sick, the method setSick will return false.
                gotSick = person.setSick();

                if (gotSick) {
                    people.depositToDoctors(5);
                }
                //If the person dies for the first time, money will be taken awa
                 died = person.die();
                if (died) {
                    people.withdrawToDoctors(3);
                }
                //If there are always at least 3 trees per person, the people will receive 5 dollars every 5 operations.
                if (woods.areThereEnoughTreesPerPerson(personArrayList.size())) {
                    person.depositMoney(5);
                }
                //1 dollar will be given to the people every 5 operations, only if they involve the creation of something.
            }
        }
        if (numOfOperations % 10 == 0) {

        }
    }

}
