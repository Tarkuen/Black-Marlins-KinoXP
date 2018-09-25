package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Visning;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowingsData implements ShowingRepository{

    Connection dbConn = DataConnection.getConn();

    List<Visning> allShowingsList = new ArrayList<>();

    public ShowingsData() throws SQLException {


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
        for (Visning visning : allShowingsList) {
        }
        return null;
    }

    public List<Visning> getAllShowingsList() {
        return allShowingsList;
    }
}
