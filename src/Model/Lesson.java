package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Lesson implements Save{
    private Date lessonDateTime;
    private int groupId;
    private int disciplineId;
    private int teacherId;
    private String homeTask;

    public Lesson(Date lessonDateTime, int groupId, int diciplineId, int teacherId) {
        this.lessonDateTime = lessonDateTime;
        this.groupId = groupId;
        this.disciplineId = diciplineId;
        this.teacherId = teacherId;
    }

    public Date getLessonDateTime() {
        return lessonDateTime;
    }

    public void setLessonDateTime(Date lessonDateTime) {
        this.lessonDateTime = lessonDateTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int diciplineId) {
        this.disciplineId = diciplineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getHomeTask() {
        return homeTask;
    }

    public void setHomeTask(String homeTask) {
        this.homeTask = homeTask;
    }

    @Override
    public String save() {
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        String date = df.format(this.lessonDateTime);
        return String.format("%s - %d - %d - %d - %s", date, this.groupId, this.disciplineId, this.teacherId, getHomeTask());
    }
}


