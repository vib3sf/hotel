package models.payment;

import models.Customer;

public interface IPayment {
    void pay(double amount, Customer customer);
}

