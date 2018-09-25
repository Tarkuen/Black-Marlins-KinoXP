package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Visning;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShowingsData implements ShowingRepository{

    Connection dbConn = DataConnection.getConn();

    public ShowingsData() throws SQLException {


    }

    @Override
    public void create() {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List populate() {
        return null;
    }
}
