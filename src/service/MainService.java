package service;

import models.*;
import models.payment.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainService {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() throws ParseException {
        String line;

        do{
            printMenu();
            line = scanner.nextLine();
            if (Objects.equals(line, "1"))
                createAccount();
            else if (Objects.equals(line, "2"))
                findAndReserveRoom();
            else if (Objects.equals(line, "3"))
                seeMyReservation();
            else if (Objects.equals(line, "4"))
                AdminService.adminMenu();
        }while(!Objects.equals(line, "5"));
    }
    private static String login(){

        String login, password;
        try {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();

            if (!HotelData.getAccounts().containsKey(login))
                login = createAccount();

            while (true) {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                if (!Objects.equals(HotelData.getAccounts().get(login).getPassword(), password)) {
                    System.out.print("Wrong password. Try again? ");
                    if (Objects.equals(scanner.nextLine(), "n"))
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
    private static String createAccount() {
        try {
            System.out.print("Enter your login: ");
            String login = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Choose type of payment (bank or cash): ");
            String strPayment = scanner.nextLine();
            IPayment payment = null;
            if (Objects.equals(strPayment, "bank")) {
                System.out.print("Enter your card: ");
                String cardNum = scanner.nextLine();
                System.out.print("Enter your month expiry date: ");
                int monthExpDate = scanner.nextInt();
                System.out.print("Enter your year expiry date: ");
                int yearExpDate = scanner.nextInt();
                System.out.print("Enter your cvc code: ");
                int cvc = scanner.nextInt();
                payment = new BankCardPayment(new BankCard(cardNum, new ExpiryDate(monthExpDate, yearExpDate), cvc));
            } else if (Objects.equals(strPayment, "cash"))
                payment = new CashPayment();
            else
                createAccount();
            HotelData.getAccounts().put(login, new Account(login, password, firstName, lastName, payment));
            System.out.println("Account created successfully!");
            return login;

        } catch (Exception ex) {
            createAccount();
        }
        return null;
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
                    Reservation reservation = new Reservation(firstDate, lastDate);
                    room.addReservation(reservation);
                    HotelData.getAccounts().get(login).setReservation(reservation);
                    HotelData.getAccounts().get(login).setDebt(room.getPrice() * (lastDate.getDay() - firstDate.getDay() + 1));
                    break;
                }
            }
        }
    }

    private static void seeMyReservation(){
        String login = login();
        if (login == null)
            return;

        System.out.println(HotelData.getAccounts().get(login).getReservation());
    }
    private static void printMenu(){
        System.out.println("\t Menu Hotel" +
                "\n1 - create account" +
                "\n2 - find and reserve room" +
                "\n3 - see reservation" +
                "\n4 - admin menu" +
                "\n5 - exit");
    }

}
