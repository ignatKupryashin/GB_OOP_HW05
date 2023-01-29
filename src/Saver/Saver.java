package Saver;

import DB.DBApi;
import Model.Save;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;

public class Saver {
    DBApi dbApi;
    String persons;
    String lessons;
    String disciplines;
    String homeworks;
    String groups;

    /**
     * Класс, который сохраняет всю базу данных
     * @param dbApi dbApi базы данных, с которой работаем
     * @param persons путь к текстовому файлу в который необходимо записыватоь данные из таблицы Persons
     * @param lessons путь к текстовому файлу в который необходимо записыватоь данные из таблицы Lessons
     * @param disciplines путь к текстовому файлу в который необходимо записыватоь данные из таблицы Disciplines
     * @param homeworks путь к текстовому файлу в который необходимо записыватоь данные из таблицы Homeworks
     * @param groups путь к текстовому файлу в который необходимо записыватоь данные из таблицы Groups
     */

    public Saver(DBApi dbApi, String persons, String lessons, String disciplines, String homeworks, String groups) {
        this.dbApi = dbApi;
        this.persons = persons;
        this.lessons = lessons;
        this.disciplines = disciplines;
        this.homeworks = homeworks;
        this.groups = groups;
    }

    public void saveAll() throws Exception{
        deleteAndSave(persons, dbApi.getAllPersons());
        deleteAndSave(lessons, dbApi.getAllLessons());
        deleteAndSave(disciplines, dbApi.getAllDisciplines());
        deleteAndSave(homeworks, dbApi.getAllHomeworks());
        deleteAndSave(groups, dbApi.getAllGroups());
    }


    private boolean createTable(String filename) throws Exception{
        File file = new File(filename);
        boolean newFile = file.createNewFile();
        return newFile;
    }


    private void deleteAndSave(String filename, HashMap<Integer, Save> data) throws Exception{
        Path filePath = Paths.get(filename);
        Files.deleteIfExists(filePath);
        createTable(filename);
        saveTable(filename, data);
    }


    public void saveTable(String filename, HashMap<Integer, Save> data) throws Exception{
        System.out.println(filename);
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
        for (int key: data.keySet()
             ) {
            String writeData = String.format("%d - %s\n", key, data.get(key).save());
            System.out.println(writeData);
            writer.write(writeData);
        }
        writer.close();
    }
    //Разобраться с серилизацией

}
