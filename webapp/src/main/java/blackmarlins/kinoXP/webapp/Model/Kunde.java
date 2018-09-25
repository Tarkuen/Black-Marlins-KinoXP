package blackmarlins.kinoXP.webapp.Model;

public class Kunde {

    String name;

   public Kunde(String name){
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
