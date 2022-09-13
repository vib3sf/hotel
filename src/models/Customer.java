package models;

import models.payment.IPayment;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final IPayment payment;
    private double expense;
    Customer(String firstName, String lastName, IPayment payment, double expense){
        this.firstName = firstName;
        this.lastName = lastName;
        this.payment = payment;
        this.expense = expense;
    }
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


