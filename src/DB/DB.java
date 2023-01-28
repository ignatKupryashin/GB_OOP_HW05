package DB;

import Model.*;

import java.util.HashMap;

public class DB {
    private Table<Person> persons;
    private Table<Discipline> disciplines;
    private Table<Group> groups;
    private Table<Lesson> lessons;
    private Table<Homework> homeworks;

    public DB() {
        this.persons = new Table<Person>(new HashMap<>());
        this.disciplines = new Table<Discipline>(new HashMap<>());
        this.groups = new Table<Group>(new HashMap<>());
        this.lessons = new Table<Lesson>(new HashMap<>());
        this.homeworks = new Table<Homework>(new HashMap<>());
    }

    public Table<Person> getPersons() {
        return persons;
    }

    public Table<Discipline> getDisciplines() {
        return disciplines;
    }

    public Table<Group> getGroups() {
        return groups;
    }

    public Table<Lesson> getLessons() {
        return lessons;
    }

    public Table<Homework> getHomeworks() {
        return homeworks;
    }
}
