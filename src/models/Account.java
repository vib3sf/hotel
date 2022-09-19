package models;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String login;
    private String password;
    private final String firstName;
    private final String lastName;
    private double debt;

    private final List<Reservation> reservations = new ArrayList<>() {
    };
    public Account(String login, String password, String firstName, String lastName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public double getDebt() {
        return debt;
    }

    public void addDebt(double debt) {
        this.debt += debt;
    }
    public void subDebt(double debt){
        this.debt -= debt;
        if (this.debt < 0)
            this.debt = 0;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }


    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void removeReservation(int numReserve){
        reservations.remove(numReserve);
    }

    @Override
    public String toString() {
        return "Login: " + login +
                "\nPassword: " + password +
                "\nName: " + firstName + " " + lastName +
                "\nDebt: " + debt;
    }
}


