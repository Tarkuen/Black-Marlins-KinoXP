package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Visning;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowingsRepository implements IShowingRepository{


   private DataConnection dataConnection;


    public ShowingsRepository() throws SQLException {
       dataConnection = DataConnection.getInstance();
    }


    @Override
    public void create(Date showing_Date, Integer movie_ID, int cinema_ID) {

    }

    @Override
    public Visning read(int id) {
     return null;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List populate() {

        return null;
    }

    @Override
    public List readAll(int id) {
        return null;
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }
}
