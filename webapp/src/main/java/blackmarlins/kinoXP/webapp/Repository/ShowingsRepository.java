package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Showing;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
  Showing m = new Showing();
  ResultSet rs;

  try (Connection conn = databaseConnection.getConn()){

   Statement statement = conn.createStatement();
   rs = statement.executeQuery("SELECT showing_id, showing_datetime, fk_movie_id, fk_cinema_id FROM Showing WHERE showing_id="+id);

   if(rs!=null){
    int i = 1;
    while(rs.next()){
     m = new Showing(
             rs.getInt(i++),
             rs.getTimestamp(i++).toLocalDateTime(),
             rs.getInt(i++),
             rs.getInt(i)
     );
    }
    return m;
   }
  }

  catch (SQLException e) {
   e.printStackTrace();
  }

  return m;
 }

 @Override
 public int fetchReservation(int showingId, int cinemaId) {
     ResultSet rs = null;
     int remainingSeats = 0;
     int cinemaSeats= 0;
     try (Connection conn = databaseConnection.getConn()) {
         PreparedStatement pstms = conn.prepareStatement(
                 "SELECT cinema_seats\n" +
                         "FROM Showing " +
                         "INNER JOIN CinemaHall ON ? = cinema_id");
         pstms.setInt(1, cinemaId);
         rs = pstms.executeQuery();
         while (rs.next()) {
             cinemaSeats = rs.getInt("cinema_seats");
         }
     } catch (SQLException ex) {
         System.out.println("Error fetching cinema seats");
         ex.printStackTrace();
     }

  try (Connection conn = databaseConnection.getConn()) {

         Statement statement2 = conn.createStatement();
      rs = statement2.executeQuery("SELECT reservation_customer_seat\n" +
                 "FROM Reservation WHERE fk_showing_id="+showingId);

         while (rs.next()) {
             int temp = rs.getInt("reservation_customer_seat");
             remainingSeats= remainingSeats+temp;
         }

         remainingSeats = cinemaSeats -remainingSeats;
         if(remainingSeats==0){
             return  cinemaSeats;
         }
         else{
             return remainingSeats;
         }

   } catch (SQLException ex) {
         ex.printStackTrace();
   }



     return 0;
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


  try (Connection conn = databaseConnection.getConn()) {
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