package Model;

public class Homework {
    private int studentId;
    private int lessonId;
    private String homeWorkText;
    private Mark mark;

    public Homework(int studentId, int lessonId, String tomeWorkText) {
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.homeWorkText = tomeWorkText;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getHomeWorkText() {
        return homeWorkText;
    }

    public void setHomeWorkText(String homeWorkText) {
        this.homeWorkText = homeWorkText;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
