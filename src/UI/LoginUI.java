package UI;

import java.util.HashMap;
import java.util.Scanner;
import DB.*;
import Controller.*;
import Model.Person;

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
                HashMap persons = dbApi.getAllPersons();
                for (Object key: persons.keySet()
                     ) {
                    System.out.println(String.format("%d - %s", (Integer)key, (Person)(persons.get(key))));
                }
                System.out.println("Введите id");
                int login = scanner.nextInt();
                System.out.println("Введите пароль");
                String password = scanner.next();
                if (Login.check(dbApi, login, password)){
                    user = login;
                    flag = false;
                }
        }
    }

    private void runUi(){
        switch (dbApi.getPerson(this.user).getRole())
        {
            case (1):
                AdminUI adminUI = new AdminUI(scanner, dbApi, user);
                adminUI.run();
                break;
            case (2):
                TeacherUI teacherUI = new TeacherUI(scanner, dbApi, user);
                teacherUI.run();
                break;
            case (3):
                StudentUI studentUI = new StudentUI(scanner, dbApi, user);
                studentUI.run();
        }
    }
}
