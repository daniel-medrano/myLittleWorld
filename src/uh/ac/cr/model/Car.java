package uh.ac.cr.model;

public class Car extends Vehicle {

    private Person[] creators;

    public Car (int ID, String brandCar, Person[] creators){
        super( ID, brandCar, 10);
        this.numberOfTires = 4;
        this.creators = creators;
    }
    public void drive (){
        System.out.println("The car is being driven...");
    }
}
