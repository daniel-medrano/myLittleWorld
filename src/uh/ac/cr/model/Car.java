package uh.ac.cr.model;

public class Car extends Vehicle {

    public Car (int ID, String brandCar){
        super( ID, brandCar, 25);
        this.numberOfTires = 4;
        this.priceVehicle = priceVehicle;
    }
    public void drive (){
        System.out.println("The car is being driven...");
    }
}
