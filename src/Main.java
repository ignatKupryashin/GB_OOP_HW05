import DB.*;
import Loader.Loader;
import Saver.Saver;
import UI.UI;

public class Main {
    public static void main(String[] args) throws Exception{
        DB db = new DB();
        DBApi dbApi = new DBApi(db);
        String persons = "src/Data/persons.txt";
        String disciplines = "src/Data/disciplines.txt";
        String homeworks = "src/Data/homeworks.txt";
        String lessons = "src/Data/lessons.txt";
        String groups = "src/Data/groups.txt";
        Loader loader = new Loader(dbApi, persons, lessons, disciplines, homeworks,groups);
        loader.run();
        UI ui = new UI(dbApi);
        ui.run();
        System.out.println("Сохранение");
        Saver saver = new Saver(dbApi, persons, lessons, disciplines, homeworks, groups);
        saver.saveAll();
        System.out.println("Конец программы");

    }
}