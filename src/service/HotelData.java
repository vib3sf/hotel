package service;

import models.Customer;
import models.Room;

import java.util.*;

public class HotelData {
    private static List<Room> rooms = new ArrayList<>();
    private static Map<String, Customer> accounts = new HashMap<>();

    public static List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        HotelData.rooms = rooms;
    }

    public static Map<String, Customer> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Map<String, Customer> accounts) {
        HotelData.accounts = accounts;
    }
}
