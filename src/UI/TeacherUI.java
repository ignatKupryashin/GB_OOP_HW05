package UI;

import Controller.AdminApi;
import Controller.StudentApi;
import Controller.TeacherApi;
import DB.DBApi;

import java.util.Scanner;

public class TeacherUI {

    Scanner scanner;
    DBApi dbApi;
    int user;
    TeacherApi teacherApi;


    public TeacherUI(Scanner scanner, DBApi dbApi, int user) {
        this.scanner = scanner;
        this.dbApi = dbApi;
        this.user = user;
        this.teacherApi = new TeacherApi(user, dbApi);
    }

    private void printMainMenu(){
        System.out.println("1 - Посмотреть список уроков\n" +
                "2 - Добавить домашнее задание\n" +
                "0 - Сохранить и выйти\n");
    }

    public void run(){
        System.out.println("Панель учителя");
        boolean flag = true;
        while (flag) {
            printMainMenu();
            String answer = scanner.next();
            switch (answer){
                case "1":
                    System.out.println(teacherApi.getTeacherLessonsString());
                    break;
                case "2":
                    System.out.println("Введите номер урока");
                    int lesson = scanner.nextInt();
                    System.out.println("Введите текст домашнего задания");
                    String hometaskText = scanner.next();
                    teacherApi.setHometask(lesson, hometaskText);
                    System.out.println("Домашнее задание назначено");
                    break;
                case "0": flag = false;
                    break;
            }

        }
    }


}
