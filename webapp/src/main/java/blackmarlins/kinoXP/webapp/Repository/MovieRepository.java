package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements IMovieRepository {

    private DataConnection dataConnection;


    public MovieRepository() throws SQLException {
        dataConnection = DataConnection.getInstance();
    }


    public DataConnection getDataConnection() {
        return dataConnection;
    }

    @Override
    public void create(String movie_name, String movie_genre) {

    }

    @Override
    public Movie read(int id) {
        return null;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Movie> populate() {
        return null;
    }

    @Override
    public List<Movie> readAll(int id) {

        try (Connection conn = dataConnection.getConn()) {
            PreparedStatement pstms = conn.prepareStatement("SELECT movie_id, movie_name, movie_genre FROM blackmarlinsdb.Movie");
            pstms.setInt(1, restordreNummer);
            rs = pstms.executeQuery();


            if (rs.next()) {
                //Husk at SQL Resultset ikke er zero-indexet.
                int i = 1;

                r = new Restordre(
                        rs.getInt(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getInt(i++),
                        rs.getString(i++),
                        rs.getDate(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getInt(i));
                return r;
            }
            return r;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

        return null;
    }
}
