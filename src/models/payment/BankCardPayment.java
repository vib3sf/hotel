package models.payment;

import models.Customer;

public class BankCardPayment implements IPayment {
    private BankCard card;

    @Override
    public void pay(double pay, Customer customer) {
        if (card.getAmount() > pay) {
            customer.setDebt(customer.getDebt() - pay);
            card.setAmount(card.getAmount() - pay);
            System.out.println("Successful payment.");
        }
        else{
            System.out.println("Error. insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "Bank card payment";
    }
}

class BankCard{
    private final String cardNum;
    private final ExpiryDate expiryDate;
    private final int cvcCode;

    private double amount;

    BankCard(String cardNum, ExpiryDate expiryDate, int cvcCode, double amount){
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
        this.cvcCode = cvcCode;
        this.amount = amount;
    }

    public String getCardNum() {
        return cardNum;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card number: " + cardNum +
                "\nExpiry date: " + expiryDate.getMonth() + "/" + expiryDate.getYear();
    }
}

class ExpiryDate{
    private final int month;
    private final int year;

    ExpiryDate(int month, int year){
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}