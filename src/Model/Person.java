package Model;

public class Person implements Save{
    private String password;
    private String name;
    private String surname;
    private int role;


    public Person(String password, String name, String surname, int role) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String save() {
        return String.format("%s - %s - %s - %d", password, name, surname, role);
    }
}
