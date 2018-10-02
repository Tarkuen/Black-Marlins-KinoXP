package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Movie;

import java.sql.*;
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
        try (Connection conn = dataConnection.getConn()) {

            PreparedStatement pstms = conn.prepareStatement("DELETE FROM blackmarlinsdb.Showing WHERE =" + id);
            pstms.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Movie> populate() {
        return null;
    }

    @Override
    public List<Movie> readAll(int id) {

            List<Movie> r = new ArrayList<>();
            ResultSet rs = null;
        try (Connection conn = dataConnection.getConn()) {
            PreparedStatement pstms = conn.prepareStatement("SELECT movie_id, movie_name, movie_genre FROM blackmarlinsdb.Movie");
            rs = pstms.executeQuery();


            while (rs.next()) {
                //Husk at SQL Resultset ikke er zero-indexet.
                int i = 1;

                Movie es = new Movie(
                        rs.getInt(i++),
                        rs.getString(i++),
                        rs.getString(i)
                );

                r.add(es);
            }
            return r;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

