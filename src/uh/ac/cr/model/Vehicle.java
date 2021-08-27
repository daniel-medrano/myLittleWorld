package uh.ac.cr.model;

public abstract class Vehicle {
    protected int ID;
    protected Person owner;
    protected Person creator;
    protected int numberOfTires;
    protected String brandVehicle;
    protected double priceVehicle;


    public Vehicle() {}

    public Vehicle(int ID, String brandVehicle, double priceVehicle, Person creator) {
        this.ID = ID;
        this.brandVehicle = brandVehicle;
        this.priceVehicle = priceVehicle;
        this.creator = creator;
    }

    public Vehicle(int ID, String brandVehicle, double priceVehicle) {
        this.ID = ID;
        this.brandVehicle = brandVehicle;
        this.priceVehicle = priceVehicle;
    }


    public String getBicycleInfo() {
        return ID + " - " + brandVehicle + ". " + owner.getFullName();
    }

    public String getBicycleInfoToBuy() {
        return ID + " - " + brandVehicle + ".";
    }

    public abstract void drive();

    public abstract String getVehicle();

    public void setOwner(Person owner) {
        this.owner = owner;
    }


    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public double getPriceVehicle() {
        return priceVehicle;
    }

    public void setPriceVehicle(int priceVehicle) {
        this.priceVehicle = priceVehicle;
    }

    public int getID() {
        return ID;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public Person getOwner() {
        return owner;
    }

    public void setPriceVehicle(double priceVehicle) {
        this.priceVehicle = priceVehicle;
    }

    public boolean hasOwner() {
        return owner != null;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }
}
