package uh.ac.cr.model;

public class Carpenter extends Person {
    private int PayHouseBuilt;

    public Carpenter (int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public int getPayHouseBuilt() {
        return PayHouseBuilt;
    }

    public void setPayHouseBuilt(int payHouseBuilt) {
        PayHouseBuilt = payHouseBuilt;
    }
}
