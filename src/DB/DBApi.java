package DB;

import Model.*;

import java.util.HashMap;
import java.util.HashSet;

public class DBApi {
    DB dataBase;

    public DBApi(DB dataBase) {
        this.dataBase = dataBase;
    }

    public HashMap getAllPersons(){
        HashMap<Integer, Person> answer= new HashMap<> (dataBase.getPersons().getTable());
        return answer;
    }

    public HashMap getAllLessons(){
        return new HashMap((dataBase.getLessons().getTable()));
    }

    public HashMap getAllDisciplines(){
        return new HashMap((dataBase.getDisciplines().getTable()));
    }

    public HashMap getAllGroups(){
        return new HashMap((dataBase.getGroups().getTable()));
    }

    public HashMap getAllHomeworks(){
        return new HashMap((dataBase.getHomeworks().getTable()));
    }


    public Person getPerson(int id){
        return dataBase.getPersons().getData(id);
    }

    public Discipline getDiscipline(int id){
        return dataBase.getDisciplines().getData(id);
    }

    public Group getGroup(int id){
        return dataBase.getGroups().getData(id);
    }

    public Lesson getLesson(int id){
        return dataBase.getLessons().getData(id);
    }

    public Homework getHomework(int id){
        return dataBase.getHomeworks().getData(id);
    }
    public boolean homeWorkExists(int studentId, int lessonId){
        boolean answer = false;
        for (Homework hw:dataBase.getHomeworks().getTable().values()
             ) {
            if (hw.getLessonId() == lessonId && hw.getStudentId() == studentId){
                answer = true;
                break;
            }
        }

        return answer;
    }

    public void setPerson(int id,Person person){
        dataBase.getPersons().setData(id, person);
    }
    public int getMaxIdPersons(){
        return dataBase.getPersons().getMaxId();
    }
    public void addPerson(int id, Person person){dataBase.getPersons().setData(id,person);}
    public void addGroup(){dataBase.getGroups().setData(new Group());}
    public void addGroup(int id){dataBase.getGroups().setData(id, new Group());}
    public void addDiscipline(int id, String name){dataBase.getDisciplines().setData(id, new Discipline(name));}
    public void addDiscipline(String name){dataBase.getDisciplines().setData(new Discipline(name));}
    public void addHomework(int id, Homework homework){dataBase.getHomeworks().setData(id, homework);}
    public void addHomework(Homework homework){dataBase.getHomeworks().setData(homework);}
    public void addLesson(int id, Lesson lesson){dataBase.getLessons().setData(id, lesson);}
    public void addLesson(Lesson lesson){dataBase.getLessons().setData(lesson);}


    public void setDiscipline(int id, Discipline discipline) {
        dataBase.getDisciplines().setData(id, discipline);
    }

    public void setGroup(int id, Group group){
        dataBase.getGroups().setData(id, group);
    }

    public void setLesson(int id, Lesson lesson){
        dataBase.getLessons().setData(id, lesson);
    }

    public void setHomework(int id, Homework homework){
        dataBase.getHomeworks().setData(id, homework);
    }

    public void setHomework(Homework homework){
        dataBase.getHomeworks().setData(homework);
    }








}
