package uh.ac.cr.model;

public class Blacksmith extends Person {
    private int PayHouseBuilt;
    private int payMaterials;

    public Blacksmith(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public int getPayHouseBuilt() {
        return PayHouseBuilt;
    }

    public void setPayHouseBuilt(int payHouseBuilt) {
        PayHouseBuilt = payHouseBuilt;
    }

    public int getPayMaterials() {
        return payMaterials;
    }

    public void setPayMaterials(int payMaterials) {
        this.payMaterials = payMaterials;
    }
}
