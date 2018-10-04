package blackmarlins.kinoXP.webapp.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Showing {

    int showingId;
    LocalDateTime showingDateTime;
    int movieId;
    int cinemaId;
    int remainingSeats;

    public Showing() {
    }

    public Showing(int showingId, LocalDateTime showingDateTime, int movieId, int cinemaId) {
        this.showingId = showingId;
        this.showingDateTime = showingDateTime;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public LocalDateTime getShowingDateTime() {
        return showingDateTime;
    }

    public void setShowingDateTime(LocalDateTime showingDateTime) {
        this.showingDateTime = showingDateTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    /*    @Override
    public String toString() {
        return "Showing{" +
                "name='" + name + '\'' +
                '}';
    }*/

}