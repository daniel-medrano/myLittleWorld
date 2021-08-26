package uh.ac.cr.model;

public class Car extends Vehicle {

    public Car (int ID, String brandCar){
        super( ID, brandCar, 10);
        this.numberOfTires = 4;
    }
    public void drive (){
        System.out.println("The car is being driven...");
    }
}
