package Controller;
import DB.*;
import Model.*;

import java.util.HashMap;

public class AdminApi {

    private DBApi dataApi;
    private Filter filter;
    private int id;
    private String name;
    private String surname;


    public AdminApi(int id, DBApi dataApi) {
        this.id = id;
        this.dataApi = dataApi;
        this.name = dataApi.getPerson(id).getName();
        this.surname = dataApi.getPerson(id).getSurname();
        this.filter = new Filter(dataApi);
    }


    public String getAllPersons(){
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Person> persons = dataApi.getAllPersons();
        for (Integer id:persons.keySet()
             ) {
            sb.append(String.format("%d - %s %s\n", id, persons.get(id).getName(), persons.get(id).getSurname()));
        }
        return sb.toString();
    }

    public void printAllPersons(){
        System.out.println(getAllPersons());
    }

    public int getMaxIdPersons(){
        return dataApi.getMaxIdPersons();
    }


    public void addNewPerson(int id, String password, String name, String surname, int role){
        Person person = new Person(password, name, surname, role);
        dataApi.addPerson(id,person);
    }


    public void changePersonName(int id, String newName){
        dataApi.getPerson(id).setName(newName);
    }

    public void changePersonSurname(int id, String newSurname){
        dataApi.getPerson(id).setSurname(newSurname);
    }

    public void changePersonPassword(int id, String password){
        dataApi.getPerson(id).setPassword(password);
    }

    public void setGroup(int personId, int groupId){

    }






    //Добавлять Person и изменять
    //Добавлять Уроки и изменять
    //Менять логины и пароли
    //Менять имена и фамилии (изменять каждого Person)



}