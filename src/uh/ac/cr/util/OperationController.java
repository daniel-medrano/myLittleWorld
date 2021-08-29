package uh.ac.cr.util;


import uh.ac.cr.manager.World;
import uh.ac.cr.model.Person;
import uh.ac.cr.model.Woods;

import java.util.ArrayList;

public class OperationController {

    private int numOfOperations;
    private int numOfCreations;
    private int numOfDeadPeople;
    private int numOfSickPeople;

    //TODO - Change name to doctors.
    private World world;

    public OperationController(World world) {
        this.world = world;
        numOfOperations = 0;
        numOfCreations = 0;
    }


    public void checkNumOfCreations(){
        if (numOfCreations % 5 == 0){
            world.depositToAllPeople(1);
        }
    }


    //2 means that the person will get sick, 1 means that the person will stay healthy.
    public void checkNumOfOperations(ArrayList<Person> personArrayList, Woods woods) {

        if (numOfOperations % 5 == 0) {

            boolean gotSick;
            boolean died;

            for (Person person : personArrayList) {
                gotSick = false;
                died = false;
                //If the person gets sick for the first time, the var gotSick will be set to true, if the person was already sick, the method setSick will return false.
                gotSick = person.setSick();
                //TODO TEST
                if (gotSick) {
                    System.out.println("\nMESSAGE: The person " + person.getFullName() + " got sick.\n");
                    world.depositToDoctors(5);
                    increaseNumOfSickPeople();
                    continue;
                }
                //If the person dies for the first time, money will be taken awa
                 died = person.die();
                if (died) {
                    world.withdrawToDoctors(3);
                    increaseNumOfDeadPeople();
                } else {
                    decreaseNumOfSickPeople();
                }
                //If there are always at least 3 trees per person, the people will receive 5 dollars every 5 operations.
                if (woods.areThereEnoughTreesPerPerson(personArrayList.size())) {
                    person.depositMoney(5);
                }
                //1 dollar will be given to the people every 5 operations, only if they involve the creation of something.
            }
        }
        if (numOfOperations >= 10 && numOfOperations % 10 == 0) {
            woods.decreaseTrees(5);
        }
        if (numOfOperations % 15 == 0){

        }
    }

    public int getNumOfOperations() {
        return numOfOperations;
    }

    public int getNumOfDeadPeople() {
        return numOfDeadPeople;
    }

    public int getNumOfSickPeople() {
        return numOfSickPeople;
    }

    public void increaseNumOfDeadPeople() {
        this.numOfDeadPeople++;
    }

    public void increaseNumOfSickPeople() {
        this.numOfSickPeople++;
    }

    public void decreaseNumOfSickPeople() {
        this.numOfSickPeople--;
    }

    public void increaseNumOfCreations() {
        numOfCreations++;
    }

    public void increaseNumOfOperations() {
        numOfOperations++;
    }
}
