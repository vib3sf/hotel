package models.payment;

import models.Customer;

public class CashPayment implements IPayment {
    @Override
    public void pay(double amount, Customer customer) {
        customer.setDebt(customer.getDebt() - amount);
    }

    @Override
    public String toString() {
        return "Cash payment";
    }
}
