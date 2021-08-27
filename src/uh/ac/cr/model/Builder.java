package uh.ac.cr.model;

public class Builder extends Person {

    public Builder(int id, String name, String lastName) {
        super(id, name, lastName, 0);
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

    public String getPerson() {
        return "\t\t\"Builder\": {" + "\n" +
                "\t\t\t\"id\": " + id + ",\n" +
                "\t\t\t\"name\": "  + "\"" + name  + "\"" + ",\n" +
                "\t\t\t\"lastName\": "  + "\"" + lastName  + "\"" + ",\n" +
                "\t\t\t\"income\": " + income + ",\n" +
                "\t\t\t\"sick\": " + sick + ",\n" +
                "\t\t\t\"dead\": " + dead + "\n" +
                "\t\t}";
    }

}