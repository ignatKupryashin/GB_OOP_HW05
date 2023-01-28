package Loader;

import DB.DBApi;
import Model.Person;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {

    DBApi dbApi;
    String persons;
    String lessons;
    String disciplines;
    String homeworks;
    String groups;

    public Loader(DBApi dbApi, String persons, String lessons, String disciplines, String homeworks, String groups) {
        this.dbApi = dbApi;
        this.persons = persons;
        this.lessons = lessons;
        this.disciplines = disciplines;
        this.homeworks = homeworks;
        this.groups = groups;
    }

    //Создаем файлы, если их нет
    public void run() throws Exception{
        createPersons(persons);
        createLessons(lessons);
        createDisciplines(disciplines);
        createHomeworks(homeworks);

    }



    private boolean createTable(String filename) throws Exception{
        File file = new File(filename);
        boolean newFile = file.createNewFile();
        return newFile;
    }

    private void createPersons(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(lessons)){
            reader.loadLessons();
        }
        else {
                dbApi.addPerson(0, new Person("admin", "admin", "admin", 1))}
    }



    private void createLessons(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(lessons)){
            reader.loadLessons();
        }
    }

    private void createDisciplines(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(lessons)){
            reader.loadDisciplines();
        }
    }


    private void createHomeworks(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(lessons)){
            reader.loadHomeworks();
        }
    }





}
