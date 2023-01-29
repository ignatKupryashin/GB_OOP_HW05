package UI;

import Controller.AdminApi;
import DB.DBApi;
import Model.Lesson;

import java.util.Date;
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
            String answer = scanner.next();
            switch (answer){
                case "1":
                    adminApi.printAllPersons();
                    break;
                case "2": addPerson();
                    break;
                case "3": changePerson();
                    break;
                case "4": addDiscipline();
                    break;
                case "5": addLesson();
                    break;
                case "6": addGroup();
                    break;
                case "7": addPersonToGroup();
                    break;
                case "0": flag = false;
                    break;
            }

        }
    }


    private void printMainMenu(){
        System.out.println("1 - Показать все учётные записи\n" +
                "2 - Добавить пользователя\n" +
                "3 - Изменить пользователя\n" +
                "4 - Добавить дисциплину\n" +
                "5 - Добавить урок\n" +
                "6 - Создать группу\n" +
                "7 - Добавить человека в группу\n" +
                "0 - Сохранить и выйти\n");
    }

    private void addGroup(){
        System.out.println("Введите номер группы");
        int id = scanner.nextInt();
        dbApi.addGroup(id);
    }


    private void addPersonToGroup(){
        System.out.println("Введите номер группы");
        int idGroup = scanner.nextInt();
        System.out.println("Введите id студента");
        int idStudent = scanner.nextInt();
        dbApi.getGroup(idGroup).addMember(idStudent);

    }





    private void addPerson(){
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
        String password = scanner.next();
        adminApi.addNewPerson(login, password, name, surname, role);
        System.out.println(String.format("Учётная запись %d создана", login));

    }

    private void changePerson(){
        System.out.println("Введите id учётной записи, которую следует изменить. Для выхода введите \"-1\"");
        int idPerson = scanner.nextInt();
        System.out.println("1 - Имя\n2 - Фамилия\n3 - Пароль\nРоль");
        System.out.println("Введите параметр, который необходимо изменить:");
        String answer = scanner.next();
        System.out.println("Введите новое значение:");
        String newData = scanner.next();
        switch (answer) {
            case "1":
                dbApi.getPerson(idPerson).setName(newData);
                break;
            case "2":
                dbApi.getPerson(idPerson).setSurname(newData);
                break;
            case "3":
                dbApi.getPerson(idPerson).setPassword(newData);
                break;
            case "4":
                dbApi.getPerson(idPerson).setRole(Integer.parseInt(newData));
                break;
        }

    }


    private void addDiscipline(){
        System.out.println("Введите название");
        String newDiscipline = scanner.next();
        dbApi.addDiscipline(newDiscipline);
    }

    private void addLesson(){


        System.out.println("Введите id Преподавыателя");
        int idTeacher = scanner.nextInt();
        System.out.println("Введите id дисциплины");
        int idDiscipline = scanner.nextInt();
        System.out.println("Введите id группы");
        int idGroup = scanner.nextInt();
        dbApi.addLesson(new Lesson(new Date(), idGroup, idDiscipline, idTeacher));

    }




    private void printRoles(){
        System.out.println("1 - Администратор\n" +
                "2 - Преподаватель\n" +
                "3 - Студент");
    }




}
