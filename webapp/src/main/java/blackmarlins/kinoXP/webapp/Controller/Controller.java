package blackmarlins.kinoXP.webapp.Controller;

import blackmarlins.kinoXP.webapp.Model.Customer;
import blackmarlins.kinoXP.webapp.Model.Movie;
import blackmarlins.kinoXP.webapp.Model.Reservation;
import blackmarlins.kinoXP.webapp.Model.Showing;
import blackmarlins.kinoXP.webapp.Repository.MovieRepository;
import blackmarlins.kinoXP.webapp.Repository.ReservationRepository;
import blackmarlins.kinoXP.webapp.Repository.ShowingsRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public String index(Model model) throws SQLException {
        MovieRepository movieRepository = new MovieRepository();
        List<Movie> movieList = movieRepository.readAll(0);
        if (movieList != null && movieList.size() > 0) {

            model.addAttribute("allmovies", movieList);
        }
        return "index";
    }


    @PostMapping(path = "/allshowings")
    public String showAllShowings(@RequestParam(name = "movie_id") Integer movie_id, Model model) throws SQLException {
        ShowingsRepository showingsRepository = new ShowingsRepository();
        List<Showing> showingList = showingsRepository.readAll(movie_id);

        if (showingList != null && showingList.size() > 0) {
            for (int i = 0; i < showingList.size(); i++) {
                int showingId = showingList.get(i).getShowingId();
                int cinemaId = showingList.get(i).getCinemaId();

                showingList.get(i).setRemainingSeats(showingsRepository.fetchReservation(showingId, cinemaId));


            }
        }


        if (showingList != null && showingList.size() > 0) {
            model.addAttribute("allshowings", showingList);
        }
        return "all-showings";
    }

    @PostMapping(path = "/reseverside")
    public String searchForShowings(@RequestParam(name = "showing_id") Integer showing_id, Model model) throws SQLException {
        ShowingsRepository showingsRepository = new ShowingsRepository();
        MovieRepository movieRepository = new MovieRepository();
        Showing showing = showingsRepository.read(showing_id);
        Movie movie = movieRepository.read(showing.getMovieId());
        model.addAttribute("showing", showing);
        model.addAttribute("movie", movie);
        Customer c = new Customer("","",0);
        model.addAttribute("customer", c);
        return "reserverside";
    }

    @PostMapping(path = "/successfulreservation")
    public String reservationSuccess(
//            @RequestParam("reservation") Reservation reservation,

                                     @RequestParam("showing_id") int showing_id,
                                     @RequestParam(name = "customer_phone") String customer_phone,
                                     @RequestParam(name = "customer_name") String customer_name,
                                     @RequestParam(name = "customer_seat") int customer_seat) throws SQLException {

        ShowingsRepository showingsRepository = new ShowingsRepository();
        Showing showing = showingsRepository.read(showing_id);
        ReservationRepository reservationRepository = new ReservationRepository();
        Customer customer = new Customer(customer_phone, customer_name, customer_seat);
        Reservation reservation = new Reservation(customer, showing);
        reservationRepository.create(reservation);

        return "redirect:/";
    }
}

