package blackmarlins.kinoXP.webapp.Model;

public class Showing {

    String name;

    public Showing(String name){
        this.name = name;
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
