package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Movie;

import java.util.List;

public interface IMovieRepository {

    public void create(String movie_name, String movie_genre);
    public Movie read(int id);
    public void update(int id);
    public void delete(int id);
    public List<Movie> populate();
    public List<Movie> readAll(int id);

}
