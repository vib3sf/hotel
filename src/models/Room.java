package models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Reservation> reservations;
    private final double price;
    private final int number;

    Room(double price, int number){
        reservations = new ArrayList<>();
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

    public void addReservation(Reservation reservation) {
        if (reservation.getFirstDate().before(reservation.getLastDate())) {
            boolean notReserve = true;
            for(Reservation res: reservations){
                if(res.getFirstDate().before(reservation.getLastDate()) ||
                        res.getLastDate().after(reservation.getFirstDate())) {
                    notReserve = false;
                    break;
                }
            }
            if (notReserve) {
                reservations.add(reservation);
                return;
            }
        }
            System.out.println("Error. Wrong dates.");
    }
}
