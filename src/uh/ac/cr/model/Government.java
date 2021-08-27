package uh.ac.cr.model;

public class Government implements MoneyLender {
    double income;


    public Government() {
        this.income = 0;
    }

    public boolean depositTaxes(double taxes) {
        this.income = income + taxes;
        return true;
    }

    public boolean withdrawMoney(double moneyToWithdraw) {

        // TODO ----- The amount of money that is gonna be taken away cannot be bigger than the actual income.
        if (income - moneyToWithdraw == 0) {
            this.income = income - moneyToWithdraw;
            return true;
        }else {
            return false;
        }
    }


    @Override
    public void requestMoney() {

    }

    @Override
    public void lendMoney() {

    }
}
