package blackmarlins.kinoXP.webapp.Controller;

import blackmarlins.kinoXP.webapp.Model.Customer;
import blackmarlins.kinoXP.webapp.Model.Movie;
import blackmarlins.kinoXP.webapp.Model.Reservation;
import blackmarlins.kinoXP.webapp.Model.Showing;
import blackmarlins.kinoXP.webapp.Repository.DataConnection;
import blackmarlins.kinoXP.webapp.Repository.MovieRepository;
import blackmarlins.kinoXP.webapp.Repository.ReservationRepository;
import blackmarlins.kinoXP.webapp.Repository.ShowingsRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public String index(Model model) throws SQLException {
        MovieRepository movieRepository = new MovieRepository();
        List<Movie> movieList = movieRepository.populate();
        if (movieList != null && movieList.size() > 0) {
            model.addAttribute("allMovies", movieList);
        }
        return "Index";
    }


    @PostMapping(path = "/Allshowings")
    public String showAllShowings(@RequestParam(name = "movie_id") Integer movie_id, Model model) throws SQLException {
        ShowingsRepository showingsRepository = new ShowingsRepository();
        List<Showing> showingList = showingsRepository.readAll(movie_id);

        if (showingList != null && showingList.size() > 0) {
            model.addAttribute("allShowings", showingList);
        }
        return "all-showings";
    }

    @PostMapping(path = "/reseverside")
    public String searchForShowings(@RequestParam(name = "showing_id") Integer showing_id, Model model) throws SQLException {
        ShowingsRepository showingsRepository = new ShowingsRepository();
        Showing showing = showingsRepository.read(showing_id);
        Reservation reservation = new Reservation(showing);
        model.addAttribute(reservation);

        return "reserverside";
    }

    @PostMapping(path = "/successfullReservation")
    public String reservationSuccess(@RequestParam(name = "reservation_id") Reservation reservation,
                                     @RequestParam(name = "customer_phone") String customer_phone,
                                     @RequestParam(name = "customer_name") String customer_name,
                                     @RequestParam(name = "customer_seat") int customer_seat) throws SQLException {

        ReservationRepository reservationRepository = new ReservationRepository();
        Customer customer = new Customer(customer_phone, customer_name, customer_seat);
        Showing showing = reservation.getShowing();
        reservation = new Reservation(customer, showing);
        reservationRepository.create(reservation);

        return "successfullReservation";
    }
}

