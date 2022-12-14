package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
    private final List<Reservation> reservations = new ArrayList<>();
    private final double price;
    private final int number;

    public Room(int number, double price){
        this.price = price;
        this.number = number;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public boolean isReserve(Date firstDate, Date lastDate) {

        for(Reservation res: reservations){
            if(!((lastDate.before(res.getFirstDate())) || firstDate.after(res.getLastDate()))){
                return true;
            }
        }
        return false;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Number of room: " + number
                + "\nPrice: " + price + "\nReservations:\n");
        if (!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                res.append(reservation).append("\n");
            }
        }
        else
            res.append("No reservations.");
        return res.toString();
    }
}
