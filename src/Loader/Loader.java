package Loader;

import DB.DBApi;
import Model.Person;

import java.io.File;


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
        createGroups(groups);

    }

    private boolean createTable(String filename) throws Exception{
        File file = new File(filename);
        boolean newFile = file.createNewFile();
        return newFile;
    }

    private void createPersons(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(persons)){
            reader.loadPersons();
        }
        else {
                dbApi.addPerson(0, new Person("0", "0", "0", 1));
        }
    }

    private void createLessons(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(lessons)){
            reader.loadLessons();
        }
    }

    private void createDisciplines(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(disciplines)){
            reader.loadDisciplines();
        }
    }

    private void createHomeworks(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(homeworks)){
            reader.loadHomeworks();
        }
    }

    private void createGroups(String filename) throws Exception{
        Reader reader = new Reader(filename, dbApi);
        if (!createTable(groups)){
            reader.loadGroups();
        }
    }

}
