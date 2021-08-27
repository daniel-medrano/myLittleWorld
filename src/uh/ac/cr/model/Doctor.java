package uh.ac.cr.model;

public  class Doctor extends  Person{
    private String specialization;



    public Doctor(int id, String name, String lastName, String specialization) {
        super(id, name, lastName,0);
        this.specialization = specialization;
    }

    @Override
    public void requestMoney() {
    }
    @Override
    public void lendMoney(){}

    public void depositMoney(){
    }


    public void withdrawMoney(){
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialty(String specialization) {
        this.specialization = specialization;
    }

    public String getPerson() {
        return "\t\t\"Doctor\": {" + "\n" +
                "\t\t\t\"id\": " + id + ",\n" +
                "\t\t\t\"name\": " + "\"" + name + "\"" + ",\n" +
                "\t\t\t\"lastName\": " + "\"" + lastName  + "\"" + ",\n" +
                "\t\t\t\"income\": " + income + ",\n" +
                "\t\t\t\"sick\": " + sick + ",\n" +
                "\t\t\t\"dead\": " + dead + "\n" +
                "\t\t}";
    }


}
