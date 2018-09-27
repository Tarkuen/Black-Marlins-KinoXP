package blackmarlins.kinoXP.webapp.Repository;

import blackmarlins.kinoXP.webapp.Model.Reservation;

import java.sql.Date;
import java.util.List;

public interface iReservationRepository {

    public void create(int customer_phone_number, String customer_full_name, int customer_seat_number, int showing_id);
    public Reservation read(int id);
    public void update(int id);
    public void delete(int id);
    public List<Reservation> populate();
    public List<Reservation> readAll(int id);

}
