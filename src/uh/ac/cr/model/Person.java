package uh.ac.cr.model;

public abstract class Person implements MoneyLender{
    protected int id;
    protected String name;
    protected String lastName;
    protected double income;
    protected boolean sick;
    protected boolean dead;

    public Person(int id, String name, String lastName, double income) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.income = income;
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

    public boolean depositMoney(double moneyToDeposit) {
        this.income = income + moneyToDeposit;
        return true;
    }
    //TODO - Revisar si el limite para quitar dinero es 0...
    public boolean withdrawMoney(double moneyToWithdraw) {
        //The amount of money that is gonna be taken away cannot be bigger than the actual income.
        if (income - moneyToWithdraw >= 0) {
            this.income = income - moneyToWithdraw;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSick() {
        //If the number is 2 and the person is not sick then that means that the person will get sick.
        if (!isSick() && (int)(Math.random()*2+1) == 2) {
            this.sick = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean die() {
        //When the num is 2 that means that the person will die, that if the person is sick and not dead.
        if (isSick() && !isDead() && (int)(Math.random()*2+1) == 2) {
            this.dead = true;
            return true;
        } else {
            this.sick = false;
            return false;
        }
    }

    public void increaseCars() {
        this.cars++;
    }
    public void increaseHouses (){
        this.houses++;
    }

    // TODO falta prestamo
    public String getPersonStatistics() {
        return "Name: " + name + "\n" +
                "Income: " + income + "\n"+
                "Cars: " + cars + "\n" +
                "Houses: " + houses  + "\n";
    }

    /*
    *
    * name: name
    * income: income
    * cars: cars
    *
    *
    *
    *
    * */


    public abstract String getPerson();

    public String getPersonInfo() {
        return id + " - " + name + " " + lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public boolean hasMoney(double moneyToCompare) {
        return moneyToCompare <= income;
    }

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
        return income;
    }

    public void setSalary(double salary) {
        this.income = salary;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
