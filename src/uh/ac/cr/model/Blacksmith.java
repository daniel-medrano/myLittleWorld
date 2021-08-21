package uh.ac.cr.model;

public class Blacksmith extends Person {

    private int payMaterials;

    public Blacksmith(int id, String name, String lastName) {
        //The blacksmith is created with 3 dollar in favor.
        super(id, name, lastName, 3);
    }

    @Override
    public void requestMoney(){
    }
    @Override
    public void lendMoney(){}

    public void depositMoney(){
    }

    public void withdrawMoney(){
    }


    public int getPayMaterials() {
        return payMaterials;
    }

    public void setPayMaterials(int payMaterials) {
        this.payMaterials = payMaterials;
    }


}
