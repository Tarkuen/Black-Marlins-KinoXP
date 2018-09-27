package blackmarlins.kinoXP.webapp.Repository;


import java.sql.Date;
import java.util.List;

public interface IShowingRepository {

    public void create(Date showing_Date, Integer movie_ID, int cinema_ID);
    public void read(int id);
    public void update(int id);
    public void delete(int id);
    public List populate();
    public List readAll(int id);

}
