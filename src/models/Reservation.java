package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private final Date firstDate;
    private Date lastDate;

    private int numbRoom;


    public Reservation(Date firstDate, Date lastDate, int numbRoom){
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.numbRoom = numbRoom;
    }

    public Date getFirstDate() {
        return firstDate;
    }


    public Date getLastDate() {
        return lastDate;
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        return "from " + dateFormat.format(firstDate) + " to " + dateFormat.format(lastDate) +
                "\nNumber of room: " + numbRoom;
    }
}
