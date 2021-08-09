package uh.ac.cr.model;
import  java.util.ArrayList;
public class Chef extends Person {
    private ArrayList recipes;

    public Chef(int id, String name, String lastName, double salary, ArrayList<String> recipes) {
        super(id, name, lastName, salary);

        this.recipes = recipes;
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
    public void withdrawMoney(){
    }


}
