package uh.ac.cr.model;

public class Bicycle extends Vehicle{

    public Bicycle (String brandBicycle, double priceVehicle){
        super(brandBicycle);
        this.numberOfTires = 2;
        this.priceVehicle = priceVehicle;
    }

    public void drive () {
        System.out.println("The bicycle is being driven...");
    }
}
