package uh.ac.cr.model;

public  class Doctor extends  Person{
    private String specialization;



    public Doctor(int id, String name, String lastName, double salary, String specialization) {
        super(id, name, lastName,salary);
        this.specialization = specialization;
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


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


}