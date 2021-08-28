package uh.ac.cr.model;

public class Bicycle extends Vehicle{

    public Bicycle (int ID, String brandBicycle, Person creator){
        super(ID, brandBicycle, 3, creator);
        this.numberOfTires = 2;
    }

    public void drive () {
        System.out.println("The bicycle is being driven... you must keep the balance and pedal continuously.");
        owner.depositMoney(0.1);
    }

    public String getVehicle() {
        return "\t\t\"Bicycle\": {" + "\n" +
                "\t\t\t\"id\": " + ID + ",\n" +
                "\t\t\t\"brand\": "  + "\"" + brandVehicle  + "\"" + ",\n" +
                "\t\t\t\"creator\": {" + creator.getId() + "}\n" +
                "\t\t}";
    }
}
