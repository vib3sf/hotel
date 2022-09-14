package models;

import models.payment.IPayment;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final IPayment payment;
    private double debt;

    private Reservation reservation;
    public Customer(String firstName, String lastName, IPayment payment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.payment = payment;
        reservation = null;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                "\nType of payment: " + payment +
                "\nExpensive: " + debt;
    }
}


