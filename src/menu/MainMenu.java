package menu;

import models.*;
import service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);


    public static void menu() {
        new AccountService();
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
                    seeReservations();
                else if (Objects.equals(choice, "4"))
                    removeReservation();
                else if (Objects.equals(choice, "5"))
                    payDebt();
                else if (Objects.equals(choice, "6"))
                    changePassword();
                else if (Objects.equals(choice, "7"))
                    AdminMenu.adminMenu();
            } while (!Objects.equals(choice, "8"));
        }catch (Exception ex){
            System.out.println("Wrong input.");
            menu();
        }
    }

    private static void createAccount() {
        try {
            System.out.print("Enter your login: ");
            String login = scanner.nextLine();
            if (AccountService.accountIsExist(login)){
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
            AccountService.addAccount(login, password, firstName, lastName);
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
        if (firstDate.after(lastDate)) {
            System.out.println("Wrong values. Try again?");
            findAndReserveRoom();
            if (Objects.equals(scanner.nextLine(), "y"))
                findAndReserveRoom();
            return;
        }

        for(Room room : Objects.requireNonNull(RoomService.getFreeRooms(firstDate, lastDate))){
            System.out.println(room + "\nMake a reservation?(y/n) ");
            if(Objects.equals(scanner.nextLine(), "y")) {
                Reservation reservation = new Reservation(firstDate, lastDate, room.getNumber());
                room.addReservation(reservation);
                AccountService.getAccount(login).addReservation(reservation);
                AccountService.getAccount(login).addDebt(room.getPrice() * (lastDate.getDay() - firstDate.getDay() + 1));
                return;
            }
        }
        System.out.println("Sorry, not available rooms for this time.");
    }

    private static void seeReservations(){
        String login = login();
        printReservations(login);
    }

    private static void removeReservation(){
        String login = login();
        printReservations(login);
        System.out.print("Choose num reservation: ");
        AccountService.getAccount(login).removeReservation(scanner.nextInt() - 1);
    }


    private static void printReservations(String login){
        int i = 0;
        for (Reservation reservation : AccountService.getAccount(login).getReservations())
            System.out.println("Num of reservation: " + ++i + "\n" + reservation);
    }


    private static void changePassword(){
        String login = login();
        System.out.print("Enter new password: ");
        AccountService.getAccount(login).setPassword(scanner.nextLine());
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
            System.out.print("Your debt: " + AccountService.getAccount(login).getDebt() +
                    "\nEnter the amount to be paid: ");
            AccountService.getAccount(login).subDebt(scanner.nextDouble());
        }catch (Exception ex){
            System.out.println("Wrong input.");
        }

    }
    private static String login(){

        String login, password;
        try {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();

            if (!AccountService.accountIsExist(login)) {
                System.out.println("Login is not found. Try again?");
                if (Objects.equals(scanner.nextLine(), "y"))
                    return login();
                return null;
            }
            while (true) {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                if (!Objects.equals(AccountService.getAccount(login).getPassword(), password)) {
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
                "\n3 - see reservations" +
                "\n4 - remove reservation" +
                "\n5 - pay debt" +
                "\n6 - change password" +
                "\n7 - admin menu" +
                "\n8 - exit");
    }

}
