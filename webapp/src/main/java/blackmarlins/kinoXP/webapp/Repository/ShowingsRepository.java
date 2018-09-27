package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Visning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowingsRepository implements IShowingRepository{

    private List<Visning> allShowingsList;
    DataConnection dataConnection;


    public ShowingsRepository() throws SQLException {
       this.allShowingsList = new ArrayList<>();
       dataConnection = DataConnection.getInstance();
    }

    @Override
    public void create() {

    }

    @Override
    public void read(int id) {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List populate() {
        List<Visning> allShowingsList = new ArrayList<>();
        for (Visning visning : allShowingsList) {
        }
        return null;
    }

    @Override
    public List readAll(int id) {
        List<Visning> allShowingsList = new ArrayList<>();
        try {
            Connection dbConn = DataConnection.getConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Visning> getAllShowingsList() {
        return allShowingsList;
    }
}
