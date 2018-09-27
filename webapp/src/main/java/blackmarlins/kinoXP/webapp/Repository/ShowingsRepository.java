package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Showing;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowingsRepository implements IShowingRepository {


 private DataConnection databaseConnection;


 public ShowingsRepository() throws SQLException {
  databaseConnection = DataConnection.getInstance();
 }


 public DataConnection getDataConnection() {
  return databaseConnection;
 }

 @Override
 public void create(Date showing_Date, Integer movie_ID, int cinema_ID) {

 }

 @Override
 public Showing read(int id) {
  return null;
 }

 @Override
 public void update(int id) {

 }

 @Override
 public void delete(int id) {

 }

 @Override
 public List<Showing> populate() {
  return null;
 }

 @Override
 public List<Showing> readAll(int id) {

  List<Showing> showings = new ArrayList<>();
  ResultSet rs = null;

  try (Connection conn = DataConnection.getConn()) {
   PreparedStatement pstms = conn.prepareStatement("SELECT showing_id, showing_datetime, fk_movie_id, fk_cinema_id FROM Showing WHERE fk_movie_id=?;");
   pstms.setInt(1, id);
   rs = pstms.executeQuery();
   while (rs.next()) {
    Showing s = new Showing(
            rs.getInt("showing_id"),
            rs.getTimestamp("showing_datetime").toLocalDateTime(),
            id,
            rs.getInt("fk_cinema_id")
    );
    showings.add(s);
   }
   return showings;
  } catch (SQLException ex) {
   ex.printStackTrace();


   return null;

  }
 }
}