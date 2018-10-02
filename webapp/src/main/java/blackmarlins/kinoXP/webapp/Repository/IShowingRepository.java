package blackmarlins.kinoXP.webapp.Repository;


import blackmarlins.kinoXP.webapp.Model.Showing;

import java.sql.Date;
import java.util.List;

public interface IShowingRepository {

    public void create(Date showing_Date, Integer movie_ID, int cinema_ID);
    public Showing read(int id);
    public int fetchReservation(int showingId, int cinemaId);
    public void update(int id);
    public void delete(int id);
    public List<Showing> populate();
    public List<Showing> readAll(int id);

}
