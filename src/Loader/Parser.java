package Loader;
import DB.*;
import Model.Homework;
import Model.Lesson;
import Model.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Parser {
    DBApi dbApi;

    public Parser(DBApi dbApi) {
        this.dbApi = dbApi;
    }

    private String[] parseFileString(String inputData){
        String[] data = inputData.split("--");
        return data;
    }


    public void parsePerson(String inputData){
        String[] data = inputData.split(" - ");
        dbApi.addPerson(Integer.parseInt(data[0]), new Person(data[1], data[2], data[3], Integer.parseInt(data[4])));
    }

    public void parseDiscipline(String inputData){
        String[] data = inputData.split(" - ");
        dbApi.addDiscipline(Integer.parseInt(data[0]),data[1]);
    }

    public void parseGroup(String inputData){
        String[] data = inputData.split(" - ");
        int groupNumber = Integer.parseInt(data[0]);
        dbApi.addGroup(groupNumber);
        String[] members = data[1].split(", ");
        for (String member:members
             ) {
            dbApi.getGroup(groupNumber).addMember(Integer.parseInt(member));
        }
    }

    public void parseLesson(String inputData) throws Exception{
        System.out.println(inputData);
        String[] data = inputData.split(" - ");
        System.out.println(Arrays.toString(data));
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        Date date = df.parse(data[1]);
        dbApi.addLesson(Integer.parseInt(data[0]), new Lesson(date, Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
        dbApi.getLesson(Integer.parseInt(data[0])).setHomeTask(data[5]);
    }

    public void parseHomework(String inputData){
        String[] data = parseFileString(inputData);
        dbApi.addHomework(new Homework(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2]));
    }
}

