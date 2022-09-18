package service;

import models.Reservation;
import models.Room;

import java.util.*;

public class RoomService {
    private static Map<Integer, Room> rooms = new HashMap<>();

    public RoomService(){
        rooms.put(1, new Room(1, 100));
        rooms.put(2, new Room(2, 150));
        rooms.put(3, new Room(3, 400));
    }

    public static Map<Integer, Room> getAllRooms() {
        return rooms;
    }

    public static List<Room> getFreeRooms(Date firstDate, Date lastDate) {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (!room.isReserve(firstDate, lastDate)) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }
    public static boolean roomIsExist(int numRoom){
        return rooms.containsKey(numRoom);
    }
    public static void addRoom(int numRoom, double price){
        rooms.put(numRoom, new Room(numRoom, price));
    }
    public static void removeRoom(int numRoom){
        rooms.remove(numRoom);
    }

}
