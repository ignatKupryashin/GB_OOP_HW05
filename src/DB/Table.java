package DB;

import java.util.HashMap;
import java.util.HashSet;

public class Table <T>{
    private HashMap<Integer, T> table;
    private int maxId;

    public Table(HashMap<Integer, T> table) {
        this.table = table;
        maxId = 0;
    }

    public int getMaxId() {
        return maxId;
    }

    public HashMap<Integer, T> getTable() {
        return table;
    }

    public T getData(int id){
        return table.get(id);
    }
    private void refreshMaxId(int newId){
        if (newId > maxId) {
            this.maxId = newId;
        }
    }

    public void setData(int id, T data){
        table.put(id, data);
        refreshMaxId(id);
    }


    public void setData(T data){
        setData(maxId + 1, data);
    }

}
