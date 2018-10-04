package blackmarlins.kinoXP.webapp.Controller;

import blackmarlins.kinoXP.webapp.Model.*;
import blackmarlins.kinoXP.webapp.Repository.*;
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

    @GetMapping(path= "/tilføj")
    public String addmovie(){return "tilføj";}

    @PostMapping(path = "/tilføj")
    public String addMovie(@ModelAttribute("movie_name") String movieName,
                           @ModelAttribute("movie_genre") String movieGenre,
                           @ModelAttribute("movie_img") String movieImg) throws SQLException {
        MovieRepository movieRepository = new MovieRepository();

        movieRepository.create(movieName, movieGenre, movieImg);

        return "redirect:/";
    }
//    @PostMapping(path = "/successfulreservation")
//    public String reservationSuccess(@RequestParam(name = "movie_name") String movie_name,
//                                     @RequestParam(name = "movie_ganre") String movie_genre,
//                                     @RequestParam(name = "movie_img") String movie_img) throws SQLException {
//
//        ReservationRepository reservationRepository = new ReservationRepository();
//        Customer customer = new Customer(customer_phone, customer_name, customer_seat);
//        Showing showing = reservation.getShowing();
//        reservation = new Reservation(customer, showing);
//        reservationRepository.create(reservation);
//
//        return "successfulreservation";
//    }

}

