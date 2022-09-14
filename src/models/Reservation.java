package models;

import java.util.Date;

public class Reservation {
    private Date firstDate;
    private Date lastDate;

    private double debt;

    public Reservation(Date firstDate, Date lastDate, double debt){
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.debt = debt;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    @Override
    public String toString() {
        return "from " + firstDate + " to " + lastDate;
    }
}
