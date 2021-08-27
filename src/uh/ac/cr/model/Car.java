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

    public String getCreators() {
        String creators = "";
        for (int i = 0; i < this.creators.length; i++) {
            if (i == this.creators.length - 1) {
                //Without a coma.
                creators = creators + " \"" + this.creators[i].getId() + "\"";
            } else if (i == 0) {
                //With only a coma.
                creators = creators + "\"" + this.creators[i].getId() + "\",";
            } else {
                //With a space and a coma.
                creators = creators + " \"" + this.creators[i].getId() + "\",";
            }
        }
        return creators;
    }

    public String getVehicle() {
        return "\t\t\"Car\": {" + "\n" +
                "\t\t\t\"id\": " + ID + ",\n" +
                "\t\t\t\"brand\": "  + "\"" + brandVehicle  + "\"" + ",\n" +
                "\t\t\t\"creators\": [" + getCreators() + "]\n" +
                "\t\t}";
    }
}
