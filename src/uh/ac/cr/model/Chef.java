package uh.ac.cr.model;
import  java.util.ArrayList;
public class Chef extends Person {
    private ArrayList recipes;

    public Chef(int id, String name, String lastName, ArrayList<String> recipes) {
        super(id, name, lastName, 0);

        this.recipes = recipes;
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


}
