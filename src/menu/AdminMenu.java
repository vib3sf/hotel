package menu;

import models.Account;
import models.Room;
import service.AccountService;
import service.RoomService;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class AdminMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static String adminPassword = "1111";

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
                changeAdminPassword();
        }while(!Objects.equals(line, "6"));

    }
    private static void addRoom() {
        System.out.println("Number of room: ");
        int numRoom = scanner.nextInt();
        if (RoomService.roomIsExist(numRoom)) {
            System.out.println("Room already exists. Try again?");
            if (Objects.equals(scanner.nextLine(), "y"))
                addRoom();
            return;
        }
        System.out.println("Price of room: ");
        double price;
        do {
            price = scanner.nextDouble();
            if (price < 0)
                System.out.println("Price cannot be negative. Try again? ");
        } while (Objects.equals(scanner.nextLine(), "y"));
        RoomService.addRoom(numRoom, price);
    }
    private static void removeRoom(){
        System.out.println("Number of room: ");
        int numRoom = scanner.nextInt();
        RoomService.removeRoom(numRoom);
    }

    private static void seeAllAccounts(){
        for (Map.Entry <String, Account> acc : AccountService.getAllAccounts().entrySet()){
            System.out.println("Email :" + acc.getKey());
            System.out.println(acc.getValue() + "\n");
        }
    }
    private static void seeAllRooms(){
        for (Map.Entry <Integer, Room> room : RoomService.getAllRooms().entrySet()){
            System.out.println(room.getValue() + "\n");
        }
    }
    private static boolean checkPassword(){
        System.out.println("Enter password: ");
        if (!Objects.equals(scanner.nextLine(), adminPassword)){
            System.out.println("Wrong password.");
            return false;
        }
        return true;
    }

    private static void changeAdminPassword(){
        System.out.println("Enter old password: ");
        if (checkPassword()){
            System.out.println("Enter new password: ");
            adminPassword = scanner.nextLine();
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
