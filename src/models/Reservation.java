package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Date firstDate;
    private Date lastDate;

    private int numbRoom;

    private double cost;

    public Reservation(Date firstDate, Date lastDate, int numbRoom, double cost){
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.numbRoom = numbRoom;
        this.cost = cost;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public int getNumbRoom() {
        return numbRoom;
    }

    public void setNumbRoom(int numbRoom) {
        this.numbRoom = numbRoom;
    }

    public double getCost() {
        return cost;
    }

    public void addCost(double cost){
        this.cost += cost;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        return "from " + dateFormat.format(firstDate) + " to " + dateFormat.format(lastDate) +
                "\nNumber of room: " + numbRoom;
    }
}
