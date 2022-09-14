package models;

import models.payment.IPayment;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final IPayment payment;
    private double debt;
    public Customer(String firstName, String lastName, IPayment payment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.payment = payment;
        debt = 0;
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
    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        if (debt < 0)
            this.debt = 0;
        else
            this.debt = debt;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                "\nType of payment: " + payment +
                "\nExpensive: " + debt;
    }
}


