package blackmarlins.kinoXP.webapp.Model;

public class Reservation {

    private int id;
    private Movie movie;
    private Customer customer;
    private Showing showing;

    public Reservation(Movie movie, Customer customer, Showing showing) {
        this.movie = movie;
        this.customer = customer;
        this.showing = showing;
    }

    public Reservation(Customer customer, Showing showing) {
        this.customer = customer;
        this.showing = showing;
    }

    public Reservation(Movie movie) {
        this.movie = movie;
    }

    public Reservation(Customer customer) {
        this.customer = customer;
    }



    public Reservation(Showing showing){
        this.showing = showing;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Showing getShowing() {
        return showing;
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
