package models.payment;

public class ExpiryDate {
    private final int month;
    private final int year;

    public ExpiryDate(int month, int year) {
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
