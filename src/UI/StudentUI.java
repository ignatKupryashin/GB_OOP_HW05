package UI;

import Controller.StudentApi;
import DB.DBApi;

import java.util.Scanner;

public class StudentUI {

    String name;
    Scanner scanner;
    DBApi dbApi;
    int user;
    StudentApi studentApi;


    public StudentUI(Scanner scanner, DBApi dbApi, int user) {
        this.scanner = scanner;
        this.dbApi = dbApi;
        this.user = user;
        studentApi = new StudentApi(user, dbApi);
    }


    public void run(){
        System.out.println("Панель студента");
        boolean flag = true;
        while (flag) {
            printMainMenu();
            String answer = scanner.next();
            switch (answer){
                case "1":
                    System.out.println(studentApi.getStudentLessonsString());
                    break;
                case "2":
                    System.out.println(studentApi.getStudentHometasks());
                    break;
                case "3":
                    System.out.println("Введите номер урока");
                    int lesson = scanner.nextInt();
                    System.out.println("Введите текст домашней работы");
                    String homeworkText = scanner.next();
                    studentApi.setHomeWork(lesson,homeworkText);
                    System.out.println("Домашняя работа сдана");
                    break;
                case "0": flag = false;
                    break;
            }

        }
    }





    private void printMainMenu(){
        System.out.println("1 - Посмотреть список уроков\n" +
                "2 - Посмотреть сисок домашних заданий\n" +
                "3 - Сдать домашнее задание\n" +
                "0 - Сохранить и выйти\n");
    }

}
