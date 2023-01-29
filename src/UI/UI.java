package UI;

import DB.*;

import java.util.Scanner;

public class UI {
    DBApi dbApi;
    Scanner scanner;
    String name;
    LoginUI loginUI;


    public UI(DBApi dbApi) {
        this.dbApi = dbApi;
        this.scanner = new Scanner(System.in);
        this.name = "УниверУнивер";
        loginUI = new LoginUI(name, scanner, dbApi);

    }

    public void run(){
        loginUI.run();
    }

}
