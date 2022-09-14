package service;

import models.Room;

import java.util.Scanner;

public class AdminService {

    private static final Scanner scanner = new Scanner(System.in);

    private void addRoom(){
        System.out.println("Number of room: ");
        int numb = scanner.nextInt();
        System.out.println("Price of room: ");
        int price = scanner.nextInt();
        HotelData.getRooms().add(new Room(numb, price));
    }
    public void adminMenu(){


    }



}
