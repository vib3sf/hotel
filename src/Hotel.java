import service.MainService;

import java.text.ParseException;

public class Hotel {
    public static void main(String[] args) throws ParseException {
        MainService hotel = new MainService();
        hotel.menu();
    }
}