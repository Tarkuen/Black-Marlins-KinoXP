package blackmarlins.kinoXP.webapp.Model;

public class Customer {

    private String name;
    private String phone;
    private int seat;

    public Customer(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
