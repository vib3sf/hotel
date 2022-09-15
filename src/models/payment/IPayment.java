package models.payment;

import models.Account;

public interface IPayment {
    void pay(double amount, Account account);
}

