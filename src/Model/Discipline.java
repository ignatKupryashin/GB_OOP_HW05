package Model;

public class Discipline implements Save{
    private String name;

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String save() {
        return this.name;
    }
}
