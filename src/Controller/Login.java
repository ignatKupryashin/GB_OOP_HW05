package Controller;
import DB.DBApi;

public abstract class Login {
    public static boolean check(DBApi dbApi, int id, String password){
        if (dbApi.getAllPersons().containsKey(id)){
        if (dbApi.getPerson(id).getPassword().equals(password)){
            return true;
        }
        else return false;
        }

        else return false;
    }
}
