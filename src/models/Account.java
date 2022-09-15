package models;


public class Account {

    private String login;
    private String password;
    private final String firstName;
    private final String lastName;
    private double debt;
    private Reservation reservation;
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
                "\nExpensive: " + debt;
    }
}


