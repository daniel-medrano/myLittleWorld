package uh.ac.cr.model;

public class Chef extends Person {

    public Chef(int id, String name, String lastName, double salary) {
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


}
