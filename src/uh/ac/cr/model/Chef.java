package uh.ac.cr.model;
import  java.util.ArrayList;
public class Chef extends Person {
    private ArrayList<String> recipes;

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


    public void withdrawMoney() {
    }

    public String getRecipes() {
        String recipes = "";
        for (int i = 0; i < this.recipes.size(); i++) {
            if (i == this.recipes.size() - 1) {
                //Without a coma.
                recipes = recipes + " \"" + this.recipes.get(i) + "\"";
            } else if (i == 0) {
                //With only a coma.
                recipes = recipes + "\"" + this.recipes.get(i) + "\",";
            } else {
                //With a space and a coma.
                recipes = recipes + " \"" + this.recipes.get(i) + "\",";
            }
        }
        return recipes;
    }

    public String getPerson() {
        return "\t\t\"Chef\": {" + "\n" +
                "\t\t\t\"id\": " + id + ",\n" +
                "\t\t\t\"name\": "  + "\"" + name  + "\"" + ",\n" +
                "\t\t\t\"lastName\": "  + "\"" + lastName  + "\"" + ",\n" +
                "\t\t\t\"income\": " + income + ",\n" +
                "\t\t\t\"sick\": " + sick + ",\n" +
                "\t\t\t\"dead\": " + dead + ",\n" +
                "\t\t\t\"recipes\": [" + getRecipes() + "]\n" +
                "\t\t}";
    }
}
