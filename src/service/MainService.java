package service;

import models.*;
import models.payment.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainService {

    private final List<Room> rooms;

    private static final Scanner scanner = new Scanner(System.in);

    public MainService(List<Room> rooms) {
        this.rooms = rooms;
    }


    private void findAndReserveRoom() throws ParseException {

        System.out.println("Choose time.\nFrom: ");
        Date firstDate = new SimpleDateFormat("dd/MM").parse(scanner.nextLine());
        System.out.println("To: ");
        Date lastDate = new SimpleDateFormat("dd/MM").parse(scanner.nextLine());
        if (firstDate.after(lastDate))
            findAndReserveRoom();

        for(Room room : rooms){
            if (!room.isReserve(firstDate, lastDate)) {
                System.out.println(room + "\nMake a reservation?(y/n) ");
                if(Objects.equals(scanner.nextLine(), "y")) {
                    room.addReservation(new Reservation(createACustomer(), firstDate, lastDate));
                    break;
                }
            }
        }

    }

    private static Customer createACustomer(){
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Choose type of payment (bank or cash): ");
        String strPayment = scanner.nextLine();
        IPayment payment = null;
        if (Objects.equals(strPayment, "bank")) {
            System.out.println("Enter your card: ");
            String cardNum = scanner.nextLine();
            System.out.println("Enter your month expiry date: ");
            int monthExpDate = scanner.nextInt();
            System.out.println("Enter your year expiry date: ");
            int yearExpDate = scanner.nextInt();
            System.out.println("Enter your cvc code: ");
            int cvc = scanner.nextInt();
            payment = new BankCardPayment(new BankCard(cardNum, new ExpiryDate(monthExpDate, yearExpDate), cvc));
        }
        else if (Objects.equals(strPayment, "cash"))
            payment = new CashPayment();
        else
            createACustomer();
        return new Customer(firstName, lastName, payment);
    }


}
