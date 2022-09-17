package models;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private String login;
    private String password;
    private final String firstName;
    private final String lastName;
    private double debt;

    private List<Reservation> reservations = new ArrayList<>() {
    };
    public Account(String login, String password, String firstName, String lastName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                "\nExpensive: " + debt;
    }
}


