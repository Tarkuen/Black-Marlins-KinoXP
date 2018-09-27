package blackmarlins.kinoXP.webapp.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.web.servlet.ModelAndView;

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


        Reservation reservation = new Reservation(film, kunde,visning);

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
        return "Film{" +
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
        return "Kunde{" +
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
        return "Visning{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Reservation{
    private Film film;
    private Kunde kunde;
    private Visning visning;

    Reservation(Film film, Kunde kunde, Visning visning){
        this.film=film;
        this.kunde=kunde;
        this.visning = visning;
    }

    @Override
    public String toString() {
        return "iReservation{" +
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