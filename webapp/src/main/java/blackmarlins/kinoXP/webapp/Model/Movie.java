package blackmarlins.kinoXP.webapp.Model;

public class Movie {
    int id;
    String name;
    String genre;
    String img;

    public String getImg() {
        return img;
    }

    public Movie() {
    }

    public Movie(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Movie(int id, String name, String genre, String img) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.img = img;
    }

    public Movie(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImg(String img) {
        this.img = img;
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
