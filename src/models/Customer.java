package models;

import models.payment.IPayment;

public class Customer {
    private String firstName;
    private String lastName;
    private IPayment payment;
    private double expense;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public IPayment getPayment() {
        return payment;
    }
    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        if (expense < 0)
            this.expense = 0;
        else
            this.expense = expense;
    }

}


