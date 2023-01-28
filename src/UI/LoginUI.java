package UI;

import java.util.Scanner;
import DB.*;
import Controller.*;

public class LoginUI {
    String name;
    Scanner scanner;
    DBApi dbApi;
    int user;


    public LoginUI(String name, Scanner scanner, DBApi dbApi) {
        this.name = name;
        this.scanner = scanner;
        this.dbApi = dbApi;
    }

    public void run(){
        System.out.println(String.format("Добро пожаловать на учебный портал %s", name));
        login();
        runUi();
        }

        private void login() {
            boolean flag = true;
            while (flag){
                System.out.println("Введите id");
                int login = scanner.nextInt();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();
                if (Login.check(dbApi, login, password)){
                    user = login;
                    flag = false;
                }
        }
    }

    private void runUi(){
        switch (user){
            case (1):
                AdminUI adminUI = new AdminUI(scanner, dbApi, user);
        }
    }
}
