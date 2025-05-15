import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {
    private String file;
    public ICDCodeTabularOptimizedForMemory(String file) {
        this.file = file;
    }

    @Override
    public String getDescription(String icd10) throws IndexOutOfBoundsException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            for (int i = 0; i < 87; i++) {
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (Character.isLetter(line.charAt(0)) && Character.isDigit(line.charAt(1)) && Character.isDigit(line.charAt(2))) {
                    String[] parts = line.split(" ", 2);
                    if (parts[0].equals(icd10)) {
                        return parts[1];
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku");
        }
        throw new IndexOutOfBoundsException("Brak");
    }
}
