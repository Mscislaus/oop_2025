import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {
    private Map<String, String> load;

    public ICDCodeTabularOptimizedForTime(String file) {
        this.load = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            for (int i = 0; i < 87; i++) {
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (Character.isLetter(line.charAt(0)) && Character.isDigit(line.charAt(1)) && Character.isDigit(line.charAt(2))) {
                    String[] parts = line.split(" ", 2);
                    load.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku");
        }
    }

    @Override
    public String getDescription(String icd10) throws IndexOutOfBoundsException {
        if (load.containsKey(icd10)) {
            return load.get(icd10);
        } else {
            throw new IndexOutOfBoundsException("Brak");
        }
    }
}
