import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, City> cities = City.parseFile("strefy.csv");
        City warsaw = cities.get("Warszawa");
        if (warsaw != null) {
            System.out.println(warsaw);
        }

        DigitalClock clock24 = new DigitalClock(warsaw, DigitalClock.Mode.H24);
        clock24.setTime(14, 30, 15);
        System.out.println("Zegar 24h: " + clock24);

        DigitalClock clock12 = new DigitalClock(warsaw, DigitalClock.Mode.H12);
        clock12.setTime(14, 30, 15);
        System.out.println("Zegar 12h: " + clock12);

        DigitalClock currentClock24 = new DigitalClock(warsaw, DigitalClock.Mode.H24);
        currentClock24.setCurrentTime();
        System.out.println("Zegar bieżący (24h): " + currentClock24);

        DigitalClock currentClock12 = new DigitalClock(warsaw, DigitalClock.Mode.H12);
        currentClock12.setCurrentTime();
        System.out.println("Zegar bieżący (12h): " + currentClock12);
    }
}