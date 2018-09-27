package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Reservation;

import java.sql.Date;
import java.util.List;

public interface iReservation {

    public void create(Date showing_Date, Integer movie_ID, int cinema_ID);
    public Reservation read(int id);
    public void update(int id);
    public void delete(int id);
    public List<Reservation> populate();
    public List<Reservation> readAll(int id);

}
