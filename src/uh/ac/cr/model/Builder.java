package uh.ac.cr.model;

public class Builder extends Person {
    private int payForHouse;


    public Builder(int id, String name, String lastName) {
        super(id, name, lastName);
    }
    @Override
    public void requestMoney(){
    }
    @Override
    public void lendMoney(){}
    @Override
    public void depositMoney(){
    }
    @Override
    public void manageMoney(){}
    @Override
    public void withdrawMoney(){
    }

    public int getPayForHouse() {
        return payForHouse;
    }

    public void setPayForHouse(int payForHouse) {
        this.payForHouse = payForHouse;
    }

}