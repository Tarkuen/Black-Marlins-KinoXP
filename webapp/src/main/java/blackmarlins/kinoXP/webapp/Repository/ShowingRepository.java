package blackmarlins.kinoXP.webapp.Repository;


import java.util.List;

public interface ShowingRepository {

    public void create();
    public void read(int id);
    public void update();
    public void delete();
    public List populate();

}
