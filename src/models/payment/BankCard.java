package models.payment;

public class BankCard {
    private final String cardNum;
    private final ExpiryDate expiryDate;
    private final int cvcCode;

    private double amount;

    public BankCard(String cardNum, ExpiryDate expiryDate, int cvcCode) {
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
