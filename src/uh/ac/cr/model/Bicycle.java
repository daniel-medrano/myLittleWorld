package uh.ac.cr.model;

public class Bicycle extends Vehicle{

    public Bicycle (int ID, String brandBicycle){
        super(ID, brandBicycle, 3);
        this.numberOfTires = 2;
    }

    public void drive () {
        System.out.println("The bicycle is being driven...");
    }
}
