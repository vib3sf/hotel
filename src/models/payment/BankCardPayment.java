package models.payment;

import models.Customer;

public class BankCardPayment implements IPayment {
    private BankCard card;

    public BankCardPayment(BankCard card){
        this.card = card;
    }
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

