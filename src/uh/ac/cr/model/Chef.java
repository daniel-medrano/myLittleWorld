package uh.ac.cr.model;

public class Chef extends Person{
    private int payForMenu;

    public Chef(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public int getPayForMenu() {
        return payForMenu;
    }

    public void setPayForMenu(int payForMenu) {
        this.payForMenu = payForMenu;
    }
}
