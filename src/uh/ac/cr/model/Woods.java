package uh.ac.cr.model;

public class Woods {
    //Var to indicate the amount of trees of the woods.
    private int trees;
    //Constructor to initialize the var trees with 20
    public Woods() {
        this.trees = 20;
    }
    //Method to increase the amount of trees.
    public void increaseTrees() {
        this.trees++;
    }
    //Method to decrease the amount of trees.
    public void decreaseTrees() {
        this.trees--;
    }
    public void decreaseTrees(int trees){
        if (!(this.trees - trees < 0)) {
            this.trees = this.trees - trees;
        }
    }

    //Method that checks if there are trees available to create a new person, there must be at least 3 trees available.
    public boolean areThereTreesAvailable(int amountPeople) {
        if (amountPeople == 0) {
            return true;
        }
        return trees % amountPeople >= 3;
    }

    public boolean areThereEnoughTreesPerPerson(int amountPeople) {
        return trees % amountPeople >= 0;
    }
    //Method to return the amount of trees.
    public int getTrees() {
        return trees;
    }

}
