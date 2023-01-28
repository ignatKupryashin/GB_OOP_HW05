package Controller;
import DB.*;
import Model.*;

import java.util.Date;
import java.util.HashMap;

public class Filter {
    DBApi api;

    public Filter(DBApi api) {
        this.api = api;
    }

    public HashMap<Integer, Lesson> filterLesson(int inputGroupId, int inputDiciplineId, int inputTeacherId){
        HashMap<Integer, Lesson> filter = api.getAllLessons();

        if (inputGroupId != -1) {
            for (Lesson lesson: filter.values()
                 ) {
                if (lesson.getGroupId()!=inputGroupId){
                    filter.remove(lesson);
                }
            }
        }

        if (inputDiciplineId != -1){
            for (Lesson lesson: filter.values()
                 ) {
                if (lesson.getDisciplineId()!=inputDiciplineId){
                    filter.remove(lesson);
                }
            }
        }
        if (inputTeacherId != -1){
            for (Lesson lesson: filter.values()
            ) {
                if (lesson.getTeacherId()!=inputTeacherId){
                    filter.remove(lesson);
                }
            }
        }

        return filter;
    }

    public Integer filterGroup(int idStudent){
        HashMap<Integer, Group> filter = api.getAllGroups();
        int answer = -1;
        for (int groupId: filter.keySet())
             {
            if (filter.get(groupId).getGroupList().contains(idStudent)){
                answer = groupId;
                break;
            }
        }
        return answer;
    }

    public HashMap<Integer, Homework> filterHomework(int inputStudentId, int inputLessonId){
        HashMap<Integer, Homework> filter = api.getAllHomeworks();
        if (inputLessonId != -1){
            for (Homework hw:filter.values()
                 ) {
                if (hw.getLessonId()!=inputLessonId){
                    filter.remove(hw);
                }
            }
        }
        if (inputStudentId != -1){
            for (Homework hw:filter.values()
            ) {
                if (hw.getStudentId()!=inputStudentId){
                    filter.remove(hw);
                }
            }
        }
        return filter;
    }
}
