package uh.ac.cr.model;

public class Blacksmith extends Person {

    private int payMaterials;

    public Blacksmith(int id, String name, String lastName, double salary) {
        super(id, name, lastName, salary);
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


    public int getPayMaterials() {
        return payMaterials;
    }

    public void setPayMaterials(int payMaterials) {
        this.payMaterials = payMaterials;
    }


}
