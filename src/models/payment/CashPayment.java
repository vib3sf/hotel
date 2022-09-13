package models.payment;

import models.Customer;

public class CashPayment implements IPayment {
    @Override
    public void pay(double amount, Customer customer) {
        customer.setExpense(customer.getExpense() - amount);
    }
}
