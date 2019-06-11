import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args)
    {
        Airport airport = Airport.getInstance();
        System.out.println("Колличество самолетов: " + airport.getAllAircrafts().size());
        System.out.println(airport.getAllAircrafts());
    }
}
