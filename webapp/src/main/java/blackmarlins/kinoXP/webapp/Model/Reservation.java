package blackmarlins.kinoXP.webapp.Model;

public class Reservation {

    private Movie movie;
    private Customer customer;
    private Showing showing;

    public Reservation(Movie movie, Customer customer, Showing showing) {
        this.movie = movie;
        this.customer = customer;
        this.showing = showing;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "movie=" + movie +
                ", customer=" + customer +
                ", showing=" + showing +
                '}';

    }
}
