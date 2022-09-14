package models;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private Date firstDate;
    private Date lastDate;

    public Reservation(Customer customer, Date firstDate, Date lastDate){
        this.customer = customer;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    @Override
    public String toString() {
        return customer.getFirstName() + " " + customer.getLastName() +
                "\nfrom " + firstDate + " to " + lastDate;
    }
}
