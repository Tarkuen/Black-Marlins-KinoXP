package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ReservationRepository implements IReservationRepository {


    private DataConnection dataConnection;


    public ReservationRepository() throws SQLException {
        dataConnection = DataConnection.getInstance();
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }

    @Override
    public void create(Reservation reservation) {
        try (Connection conn = dataConnection.getConn()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement pstmt = conn.prepareStatement
                    ("INSERT INTO blackmarlinsdb.Reservation(reservation_customer_phone, reservation_costumer_name, reservation_customer_seat, fk_showing_id ) VALUES(?,?,?,?);");
            pstmt.setString(1, reservation.getCustomer().getPhone());
            pstmt.setString(2, reservation.getCustomer().getName());
            pstmt.setInt(3, reservation.getCustomer().getSeat());
            pstmt.setInt(4, reservation.getShowing().getShowingId());

            pstmt.execute();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public Reservation read(int id) {
        Reservation r = new Reservation();
        ResultSet rs;

        try (Connection conn = dataConnection.getConn()){

            Statement statement = conn.createStatement();
            rs = statement.executeQuery("SELECT reservation_id, reservation_customer_phone, reservation_costumer_name, reservation_customer_seat, fk_showing_id FROM Reservation WHERE reservation_id="+id);

            if(rs!=null){
                int i = 1;
                while(rs.next()){
                   r = new Reservation(
                            rs.getInt(i++),
                            rs.getString(i++),
                            rs.getString(i++),
                           rs.getInt(i++),
                           rs.getInt(i)
                    );
                }
                return r;
            }
        }

        catch (SQLException e) {
            System.out.println("Exception occurred in ReservationRepo - Create");
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {
        
    }

    @Override
    public List<Reservation> populate() {
        return null;
    }

    @Override
    public List<Reservation> readAll(int id) {
        return null;
    }
}
