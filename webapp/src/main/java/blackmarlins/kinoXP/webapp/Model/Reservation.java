package blackmarlins.kinoXP.webapp.Model;

public class Reservation {

    private Film film;
    private Kunde kunde;
    private Visning visning;

    public Reservation(Film film, Kunde kunde, Visning visning) {
        this.film = film;
        this.kunde = kunde;
        this.visning = visning;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "film=" + film +
                ", kunde=" + kunde +
                ", visning=" + visning +
                '}';

    }
}
