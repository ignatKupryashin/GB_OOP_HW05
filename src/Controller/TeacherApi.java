package Controller;

import DB.DBApi;
import Model.Lesson;

import java.text.DateFormat;
import java.util.HashMap;



public class TeacherApi {

    private DBApi dbApi;
    private Filter filter;
    private int id;
    private String name;
    private String surname;

    /**
     * Класс, определяющий все возможности Учителя. Команды созданы для вызова из интерфейса
     * @param id id учителя
     * @param dbApi интерфейс базы данных, с которой мы работаем
     */



    public TeacherApi(int id, DBApi dbApi) {
        this.id = id;
        this.dbApi = dbApi;
        this.name = dbApi.getPerson(id).getName();
        this.surname = dbApi.getPerson(id).getSurname();
        this.filter = new Filter(dbApi);
    }

    public HashMap<Integer, Lesson> getTeacherLessons(){
        return filter.filterLesson(-1,-1, id);
    }


    public String getTeacherLessonsString(){
        StringBuilder teacherLessons = new StringBuilder();
        HashMap<Integer, Lesson> teacherLessonsMap = getTeacherLessons();
        for (int idLesson: teacherLessonsMap.keySet()
        ) {
            teacherLessons.append(String.format("%d - %s - %s\n", idLesson,
                    DateFormat.getDateInstance().format(teacherLessonsMap.get(idLesson).getLessonDateTime()),
                    dbApi.getDiscipline(teacherLessonsMap.get(idLesson).getDisciplineId())));
        }
        return teacherLessons.toString();
    }


    public void setHometask(int lessonId, String hometask){
        dbApi.getLesson(lessonId).setHomeTask(hometask);
    }


}


