import menu.MainMenu;
import service.AccountService;
import service.RoomService;


public class Hotel {

    public static void main(String[] args) {
        new AccountService();
        new RoomService();
        MainMenu.menu();
    }
}