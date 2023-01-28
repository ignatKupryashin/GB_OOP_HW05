package UI;

import Controller.AdminApi;
import DB.DBApi;

import java.util.Scanner;

public class AdminUI {
    Scanner scanner;
    DBApi dbApi;
    int user;
    AdminApi adminApi;

    public AdminUI(Scanner scanner, DBApi dbApi, int user) {
        this.scanner = scanner;
        this.dbApi = dbApi;
        this.user = user;
        this.adminApi = new AdminApi(user, dbApi);
    }

    public void run(){
        System.out.println("Панель администратора");
        boolean flag = true;
        while (flag) {
            printMainMenu();
            String answer = scanner.nextLine();
            switch (answer){
                case "1": adminApi.printAllPersons();
                case "2": addPerson();
            }

        }
    }



    public void printMainMenu(){
        System.out.println("1 - Показать все учётные записи\n" +
                "2 - Добавить пользователя" +
                "3 - Изменить пользователя" +
                "4 - Добавить дисциплину" +
                "5 - Добавить урок");
    }


    public void addPerson(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        int role = 0;
        while (role == 0) {
            System.out.println("Введите роль");
            printRoles();
            role = scanner.nextInt();
            if (role != 1 && role != 2 && role != 3){
                role = 0;
            }
        }
        int login = dbApi.getMaxIdPersons() + 1;
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        adminApi.addNewPerson(login, password, name, surname, role);
        System.out.println(String.format("Учётная запись %d создана", login));

    }


    private void printRoles(){
        System.out.println("1 - Студент\n" +
                "2 - Преподаватель\n" +
                "3 - Администратор");
    }




}
