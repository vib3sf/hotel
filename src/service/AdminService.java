package service;

import models.Customer;
import models.Room;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class AdminService {

    private static final Scanner scanner = new Scanner(System.in);
    private static String password = "1111";

    public static void adminMenu(){
        if (!checkPassword())
            return;

        String line;
        do{
            printAdminMenu();
            line = scanner.nextLine();
            if (Objects.equals(line, "1"))
                addRoom();
            else if (Objects.equals(line, "2"))
                removeRoom();
            else if (Objects.equals(line, "3"))
                seeAllAccounts();
            else if (Objects.equals(line, "4"))
                seeAllRooms();
            else if (Objects.equals(line, "5"))
                changePassword();
        }while(!Objects.equals(line, "6"));

    }
    private static void addRoom(){
        System.out.println("Number of room: ");
        int numRoom = scanner.nextInt();
        System.out.println("Price of room: ");
        int price = scanner.nextInt();
        HotelData.getRooms().put(numRoom, new Room(numRoom, price));
    }
    private static void removeRoom(){
        System.out.println("Number of room: ");
        int numRoom = scanner.nextInt();
        HotelData.getRooms().remove(numRoom);
    }

    private static void seeAllAccounts(){
        for (Map.Entry <String, Customer> acc : HotelData.getAccounts().entrySet()){
            System.out.println("Email :" + acc.getKey());
            System.out.println(acc.getValue() + "\n");
        }
    }
    private static void seeAllRooms(){
        for (Map.Entry <Integer, Room> room : HotelData.getRooms().entrySet()){
            System.out.println(room.getValue() + "\n");
        }
    }
    private static boolean checkPassword(){
        System.out.println("Enter password: ");
        if (!Objects.equals(scanner.nextLine(), password)){
            System.out.println("Wrong password.");
            return false;
        }
        return true;
    }

    private static void changePassword(){
        System.out.println("Enter old password: ");
        if (checkPassword()){
            System.out.println("Enter new password: ");
            password = scanner.nextLine();
            return;
        }
        System.out.println("Wrong password.");
    }

    private static void printAdminMenu(){
        System.out.println("\t Admin menu" +
                "\n1 - add room" +
                "\n2 - remove room" +
                "\n3 - see all accounts" +
                "\n4 - see all rooms and reservations" +
                "\n5 - change password" +
                "\n6 - back to main menu");
    }
}
