package uh.ac.cr.model;

public class Builder extends Person {
    private int payForHouse;


    public Builder(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public int getPayForHouse() {
        return payForHouse;
    }

    public void setPayForHouse(int payForHouse) {
        this.payForHouse = payForHouse;
    }
}