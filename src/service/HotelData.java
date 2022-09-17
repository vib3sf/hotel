package service;

import models.Account;
import models.Room;

import java.util.*;

public class HotelData {

    public HotelData(){
        accounts.put("1", new Account("1", "1", "1", "1"));
        rooms.put(1, new Room(1, 100));
        rooms.put(2, new Room(2, 150));
        rooms.put(3, new Room(3, 400));
    }
    private static Map<Integer, Room> rooms = new HashMap<>();
    private static Map<String, Account> accounts = new HashMap<>();

    public static Map<Integer, Room> getRooms() {
        return rooms;
    }
    public void setRooms(Map<Integer, Room> rooms) {
        HotelData.rooms = rooms;
    }

    public static Map<String, Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Map<String, Account> accounts) {
        HotelData.accounts = accounts;
    }
}
