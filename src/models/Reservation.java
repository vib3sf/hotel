package models;

import java.util.Date;

public class Reservation {
    private Date firstDate;
    private Date lastDate;

    public Reservation(Date firstDate, Date lastDate){
        this.firstDate = firstDate;
        this.lastDate = lastDate;
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
