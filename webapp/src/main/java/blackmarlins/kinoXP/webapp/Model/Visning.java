package blackmarlins.kinoXP.webapp.Model;

public class Visning {

    String name;

    public Visning(String name){
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
