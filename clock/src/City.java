import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class City {
    private String capital;
    private int timeZone;
    private String latitude;
    private String longitude;

    public City(String capital, int timeZone, String latitude, String longitude) {
        this.capital = capital;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCapital() {
        return capital;
    }

    private static City parseLine(String line) {
        String[] parts = line.split(",");

        String capital = parts[0];
        int timezone = Integer.parseInt(parts[1]);
        String lat = parts[2];
        String lon = parts[3].trim();

        return new City(capital, timezone, lat, lon);
    }

    public static Map<String, City> parseFile(String filePath) {
        Map<String, City> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                City city = parseLine(line);
                map.put(city.getCapital(), city);
            }

        } catch (IOException e) {
            System.err.println("Blad odczytu pliku");
        }

        return map;
    }

    @Override
    public String toString() {
        return capital + " [UTC" + (timeZone >= 0 ? "+" : "") + timeZone + "] (" + latitude + ", " + longitude + ")";
    }
}