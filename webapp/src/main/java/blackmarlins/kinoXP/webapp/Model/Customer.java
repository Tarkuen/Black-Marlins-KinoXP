package blackmarlins.kinoXP.webapp.Model;

public class Customer {

    String name;

   public Customer(String name){
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
