package view;

import controller.Menu;
import services.impl.IEmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();
        IEmployeeServiceImpl.display();
    }
}
