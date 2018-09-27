package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Cinema;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CinemaRepository implements iCinemaRepository {

    private DataConnection dataConnection;


    public CinemaRepository() throws SQLException {
        dataConnection = DataConnection.getInstance();
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }

    @Override
    public Cinema read(int id) {
        return null;
    }

    @Override
    public List<Cinema> populate() {
        return null;
    }
}
