package models.payment;

import models.Account;

public class CashPayment implements IPayment {
    @Override
    public void pay(double amount, Account account) {
        account.setDebt(account.getDebt() - amount);
    }

    @Override
    public String toString() {
        return "Cash payment";
    }
}
