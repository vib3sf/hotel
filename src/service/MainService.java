package service;

import models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainService {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        String choice;
        try {
            do {
                printMenu();
                choice = scanner.nextLine();
                if (Objects.equals(choice, "1"))
                    createAccount();
                else if (Objects.equals(choice, "2"))
                    findAndReserveRoom();
                else if (Objects.equals(choice, "3"))
                    seeReservation();
                else if (Objects.equals(choice, "4"))
                    payDebt();
                else if (Objects.equals(choice, "5"))
                    changePassword();
                else if (Objects.equals(choice, "6"))
                    AdminService.adminMenu();
            } while (!Objects.equals(choice, "7"));
        }catch (Exception ex){
            System.out.println("Wrong input.");
            menu();
        }
    }

    private static void createAccount() {
        try {
            System.out.print("Enter your login: ");
            String login = scanner.nextLine();
            if (HotelData.getAccounts().containsKey(login)){
                System.out.println("Login already exists. Try again?");
                if (Objects.equals(scanner.nextLine(), "y"))
                    createAccount();
                return;
            }
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            HotelData.getAccounts().put(login, new Account(login, password, firstName, lastName));
            System.out.println("Account created successfully!");

        } catch (Exception ex) {
            createAccount();
        }
    }

    private static void findAndReserveRoom() throws ParseException {

        String login = login();
        if (login == null)
            return;

        System.out.print("Choose time.\nFrom: ");
        Date firstDate = new SimpleDateFormat("dd/MM").parse(scanner.nextLine());
        System.out.print("To: ");
        Date lastDate = new SimpleDateFormat("dd/MM").parse(scanner.nextLine());
        if (firstDate.after(lastDate))
            findAndReserveRoom();


        for(Room room : HotelData.getRooms().values()){
            if (!room.isReserve(firstDate, lastDate)) {
                System.out.println(room + "\nMake a reservation?(y/n) ");
                if(Objects.equals(scanner.nextLine(), "y")) {
                    Reservation reservation = new Reservation(firstDate, lastDate, room.getNumber());
                    room.addReservation(reservation);
                    HotelData.getAccounts().get(login).setReservation(reservation);
                    HotelData.getAccounts().get(login).setDebt(room.getPrice() * (lastDate.getDay() - firstDate.getDay() + 1));
                    return;
                }
            }
        }
        System.out.println("Sorry, not available rooms for this time. Choose other time? ");
    }

    private static void seeReservation(){
        String login = login();
        if (login != null)
            System.out.println(HotelData.getAccounts().get(login).getReservation());

    }

    private static void changePassword(){
        String login = login();
        System.out.print("Enter new password: ");
        HotelData.getAccounts().get(login).setPassword(scanner.nextLine());
    }

    private static void payDebt(){
        try {
            String login = login();
            System.out.print("Choose type of payment(card or cash): ");
            String strPayment = scanner.nextLine();
            if (Objects.equals(strPayment, "card")) {
                System.out.print("Enter your card: ");
                String cardNum = scanner.nextLine();
                System.out.print("Enter your month expiry date: ");
                int monthExpDate = scanner.nextInt();
                System.out.print("Enter your year expiry date: ");
                int yearExpDate = scanner.nextInt();
                System.out.print("Enter your cvc code: ");
                int cvc = scanner.nextInt();
            }
            System.out.print("Your debt: " + HotelData.getAccounts().get(login).getDebt() +
                    "\nEnter the amount to be paid: ");
            HotelData.getAccounts().get(login).setDebt(HotelData.getAccounts().get(login).getDebt() - scanner.nextDouble());
        }catch (Exception ex){
            System.out.println("Wrong input.");
        }

    }
    private static String login(){

        String login, password;
        try {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();

            if (!HotelData.getAccounts().containsKey(login)) {
                System.out.println("Login is not found. Try again?");
                if (Objects.equals(scanner.nextLine(), "y"))
                    login();
                return null;
            }
            while (true) {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                if (!Objects.equals(HotelData.getAccounts().get(login).getPassword(), password)) {
                    System.out.print("Wrong password. Try again? ");
                    if (!Objects.equals(scanner.nextLine(), "y"))
                        return null;
                }
                else break;
            }
        }catch (Exception ex){
            System.out.println("Wrong input.");
            return null;
        }
        return login;
    }
    private static void printMenu(){
        System.out.println("\t Menu Hotel" +
                "\n1 - create account" +
                "\n2 - find and reserve room" +
                "\n3 - see reservation" +
                "\n4 - pay debt" +
                "\n5 - change password" +
                "\n6 - admin menu" +
                "\n7 - exit");
    }

}
