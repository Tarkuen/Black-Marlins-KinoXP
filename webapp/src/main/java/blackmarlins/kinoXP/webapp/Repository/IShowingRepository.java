package blackmarlins.kinoXP.webapp.Repository;


import blackmarlins.kinoXP.webapp.Model.Visning;

import java.sql.Date;
import java.util.List;

public interface IShowingRepository {

    public void create(Date showing_Date, Integer movie_ID, int cinema_ID);
    public Visning read(int id);
    public void update(int id);
    public void delete(int id);
    public List<Visning> populate();
    public List<Visning> readAll(int id);

}
