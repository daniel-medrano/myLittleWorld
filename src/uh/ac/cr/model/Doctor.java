package uh.ac.cr.model;

public class Doctor extends  Person{
    private String specialty;
    private int payForService;

    public Doctor(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getPayForService() {
        return payForService;
    }

    public void setPayForService(int payForService) {
        this.payForService = payForService;
    }
}
