package uh.ac.cr.model;

public abstract class Person implements MoneyLender{
    private int id;
    private String name;
    private String lastName;
    private double salary;

    public Person(int id, String name, String lastName, double salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.sick = false;
        this.dead = false;
    }
    //requisitos interface

    /**
     *
     * Se asumiria que requestMoney crea un prestamo en si.
     *
     *
     *
     *
     *
     *
     *
     *
     * **/

    public abstract void requestMoney();

    public abstract void lendMoney();

    public abstract void depositMoney();

    public abstract void withdrawMoney();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
