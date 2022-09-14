package service;

import models.Customer;
import models.Room;

import java.util.*;

public class HotelData {
    private static Map<Integer, Room> rooms = new HashMap<>();
    private static Map<String, Customer> accounts = new HashMap<>();

    public static Map<Integer, Room> getRooms() {
        return rooms;
    }
    public void setRooms(Map<Integer, Room> rooms) {
        HotelData.rooms = rooms;
    }

    public static Map<String, Customer> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Map<String, Customer> accounts) {
        HotelData.accounts = accounts;
    }
}
