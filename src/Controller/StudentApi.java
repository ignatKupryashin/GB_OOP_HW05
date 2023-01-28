package Controller;
import DB.*;
import Model.*;

import java.text.DateFormat;
import java.util.HashMap;

public class StudentApi {
    private DBApi dataApi;
    private Filter filter;
    private int id;
    private String name;
    private String surname;
    private int group;

    public StudentApi(int id, DBApi dataApi) {
        this.id = id;
        this.dataApi = dataApi;
        this.name = dataApi.getPerson(id).getName();
        this.surname = dataApi.getPerson(id).getSurname();
        this.filter = new Filter(dataApi);
        this.group = filter.filterGroup(id);
    }

    public HashMap<Integer, Lesson> getStudentLessons(){
        return filter.filterLesson(group,-1,-1);
    }


    public String getStudentLessonsString(){
        StringBuilder studentLessons = new StringBuilder();
        HashMap<Integer, Lesson> studentLessonsMap = getStudentLessons();
        for (int idLesson: studentLessonsMap.keySet()
             ) {
            studentLessons.append(String.format("%d - %s - %s\n", idLesson,
                    DateFormat.getDateInstance().format(studentLessonsMap.get(idLesson).getLessonDateTime()),
                    dataApi.getDiscipline(studentLessonsMap.get(idLesson).getDisciplineId())));
        }
        return studentLessons.toString();
    }


    public String getStudentHometasks(){
        StringBuilder studentHomeworks = new StringBuilder();
        HashMap<Integer, Lesson> studentLessonsMap = getStudentLessons();
        for (int idLesson: studentLessonsMap.keySet()
        ) {
            studentHomeworks.append(String.format("%d\n%s\n%s\n%s\n\n\n", idLesson,
                    DateFormat.getDateInstance().format(studentLessonsMap.get(idLesson).getLessonDateTime()),
                    dataApi.getDiscipline(studentLessonsMap.get(idLesson).getDisciplineId()),
                    dataApi.getLesson(idLesson).getHomeTask())
            );
        }
        return studentHomeworks.toString();
    }


    public void setHomeWork(int idLesson, String homeworkText){
        if (dataApi.homeWorkExists(id, idLesson)){
         //нужен поиск id домашки
        }
        else {
            dataApi.setHomework(new Homework(id, idLesson, homeworkText));
        }

    }







}
