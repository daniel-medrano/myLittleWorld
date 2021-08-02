package uh.ac.cr.model;

public class Vehicle {
    private int numberOfTires;
    private String nameVehicle;
    private int priceVehicle;

    public Vehicle(int numberOfTires, String nameVehicle, int priceVehicle) {
        this.numberOfTires = numberOfTires;
        this.nameVehicle = nameVehicle;
        this.priceVehicle = priceVehicle;
    }


    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public int getPriceVehicle() {
        return priceVehicle;
    }

    public void setPriceVehicle(int priceVehicle) {
        this.priceVehicle = priceVehicle;
    }
}
