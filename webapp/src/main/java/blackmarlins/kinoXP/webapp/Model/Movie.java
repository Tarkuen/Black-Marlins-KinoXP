package blackmarlins.kinoXP.webapp.Model;

public class Movie {
    int id;
    String name;
    String genre;

    public Movie() {
    }

    public Movie(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Movie(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
