package blackmarlins.kinoXP.webapp.Model;

public class Movie {

    String name;

    public Movie(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
