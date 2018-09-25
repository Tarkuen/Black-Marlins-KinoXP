package blackmarlins.kinoXP.webapp.Model;

public class Film {

    String name;

    public    Film (String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                '}';
    }
}
