package UI;

import DB.*;

import java.util.Scanner;

public class UI {
    DBApi dbApi;
    Scanner scanner;
    String name;


    public UI(DBApi dbApi) {
        this.dbApi = dbApi;
        this.scanner = new Scanner(System.in);
        this.name = "УниверУнивер";
        LoginUI loginUI = new LoginUI(name, scanner, dbApi);

    }
}
