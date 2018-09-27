package blackmarlins.kinoXP.webapp.Model;

public class Showing {

    private int id;
    private String name;

    public Showing(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "name='" + name + '\'' +
                '}';
    }

}
