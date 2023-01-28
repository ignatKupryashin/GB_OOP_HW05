package Loader;

import DB.DBApi;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
    BufferedReader bufferedReader;
    String filename;
    DBApi dbApi;
    Parser parser;

    public Reader(String filename, DBApi dbApi) throws Exception{
        this.filename = filename;
        this.dbApi = dbApi;
        this.bufferedReader = new BufferedReader(new FileReader(filename));
        this.parser = new Parser(dbApi);
    }


    public void loadPersons() throws Exception{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isBlank())) {
                parser.parsePerson(line);
            }
            else {
                break;
            }
        }
    }

    public void loadGroups() throws Exception{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isBlank())) {
                parser.parseGroup(line);
            }
            else {
                break;
            }
        }
    }

    public void loadDisciplines() throws Exception{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isBlank())) {
                parser.parseDiscipline(line);
            }
            else {
                break;
            }
        }
    }

    public void loadHomeworks() throws Exception{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isBlank())) {
                parser.parseHomework(line);
            }
            else {
                break;
            }
        }
    }

    public void loadLessons() throws Exception{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isBlank())) {
                parser.parseLesson(line);
            }
            else {
                break;
            }
        }
    }




}
