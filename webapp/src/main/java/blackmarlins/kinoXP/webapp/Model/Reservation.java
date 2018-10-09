package blackmarlins.kinoXP.webapp.Model;

public class Reservation {

    private int id;
    private Movie movie;
    private Customer customer;
    private Showing showing;

    private String customer_phone;
    private String customer_name;
    private int customer_seat;
    private int showing_id;


    public Reservation() {
    }

    public Reservation(int id, String customer_phone, String customer_name, int customer_seat, int showing_id) {
        this.id = id;
        this.customer_phone = customer_phone;
        this.customer_name = customer_name;
        this.customer_seat = customer_seat;
        this.showing_id = showing_id;
    }

    public Reservation(Movie movie, Customer customer, Showing showing) {
        this.movie = movie;
        this.customer = customer;
        this.showing = showing;
    }

    public Reservation(Customer customer, Showing showing) {
        this.customer = customer;
        this.showing = showing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_seat() {
        return customer_seat;
    }

    public void setCustomer_seat(int customer_seat) {
        this.customer_seat = customer_seat;
    }

    public int getShowing_id() {
        return showing_id;
    }

    public void setShowing_id(int showing_id) {
        this.showing_id = showing_id;
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
