package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Showing;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShowingsRepository implements IShowingRepository{


   private DataConnection dataConnection;


    public ShowingsRepository() throws SQLException {
       dataConnection = DataConnection.getInstance();
    }


    public DataConnection getDataConnection() {
        return dataConnection;
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
  return null;
 }
}
