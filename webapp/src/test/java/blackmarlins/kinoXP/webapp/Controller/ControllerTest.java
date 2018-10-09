package blackmarlins.kinoXP.webapp.Controller;

import blackmarlins.kinoXP.webapp.Model.Customer;
import blackmarlins.kinoXP.webapp.Model.Movie;
import blackmarlins.kinoXP.webapp.Model.Reservation;
import blackmarlins.kinoXP.webapp.Model.Showing;
import blackmarlins.kinoXP.webapp.Repository.MovieRepository;
import blackmarlins.kinoXP.webapp.Repository.ReservationRepository;
import blackmarlins.kinoXP.webapp.Repository.ShowingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Test
    public void index() throws Exception {
        MovieRepository movieRepository = new MovieRepository();
        List<Movie> movieList = movieRepository.readAll(1);
        assertTrue(movieList.size()!=0);
    }

    @Test
    public void showAllShowings() throws Exception {

        int movie_id = 1;
        ShowingsRepository showingsRepository = new ShowingsRepository();
        List<Showing> showingList = showingsRepository.readAll(movie_id);

        assertTrue(showingList.size()!=0);
    }

    @Test
    public void searchForShowings() throws Exception {

        Showing showing_test = new Showing(1, LocalDateTime.now(), 1,1);
        ShowingsRepository showingsRepository = new ShowingsRepository();
        MovieRepository movieRepository = new MovieRepository();
        Showing showing = showingsRepository.read(showing_test.getShowingId());
        Movie movie = movieRepository.read(showing.getMovieId());
        System.out.println(movie.getName());
        System.out.println(showing.getShowingDateTime());
    }

    @Test
    public void reservationSuccess() throws Exception {
        Showing showing_test = new Showing(1, LocalDateTime.now(), 1,1);

        ShowingsRepository showingsRepository = new ShowingsRepository();
        Showing showing = showingsRepository.read(showing_test.getShowingId());
        ReservationRepository reservationRepository = new ReservationRepository();
        Customer customer = new Customer();
        customer.setName("Jens-Jørgen");
        customer.setPhone("112");
        customer.setSeat(3);
        Reservation reservation = new Reservation(customer, showing);
        reservationRepository.create(reservation);
        assertEquals(customer.getName(), "Jens-Jørgen");

    }

//   @Test
//   public void indexController() throws Exception {
//       MockMvc mockMvc = standaloneSetup().build();
//
//       mockMvc.perform(get("/"))
//               .andExpect(
//                       view().name("HomePage")
//               );
//       mockMvc.perform(post("/"))
//               .andExpect(
//                       view().name("HomePage")
//               );
//
//
//
//   }




    @Test
    public void assembleReservation(){

        Film film = new Film("Black Panther");
        Kunde kunde = new Kunde("Hans Hansen");
        Visning visning = new Visning("2");


        ReservationD reservation = new ReservationD(film, kunde,visning);

        System.out.println(reservation.toString());

        assertEquals(reservation.getFilm().getName(), film.getName());
    }


}

class Film{
    String name;

    Film (String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Kunde{
    String name;

    Kunde(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Visning{
    String name;

    Visning(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "name='" + name + '\'' +
                '}';
    }
}
class ReservationD{
    private Film film;
    private Kunde kunde;
    private Visning visning;

    ReservationD(Film film, Kunde kunde, Visning visning){
        this.film=film;
        this.kunde=kunde;
        this.visning = visning;
    }

    @Override
    public String toString() {
        return "IReservationRepository{" +
                "film=" + film +
                ", kunde=" + kunde +
                ", visning=" + visning +
                '}';
    }

    public Film getFilm() {
        return film;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Visning getVisning() {
        return visning;
    }
}