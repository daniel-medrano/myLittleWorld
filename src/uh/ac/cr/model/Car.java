package uh.ac.cr.model;

public class Car extends Vehicle {

    public Car (String brandCar, double priceVehicle){
        super(brandCar);
        this.numberOfTires = 4;
        this.priceVehicle = priceVehicle;
    }
    public void drive (){}
}
