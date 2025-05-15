import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeathCauseStatisticList {
    private List<DeathCauseStatistic> statistics;

    public DeathCauseStatisticList() {
        this.statistics = new ArrayList<>();
    }

    public void repopulate() {
        statistics.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("zgony.csv"))) {
            String line;
            reader.readLine();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);
                statistics.add(stat);
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku");
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
        return statistics.stream()
                .sorted((a, b) -> b.getDeathCount(age).deathCount - a.getDeathCount(age).deathCount)
                .limit(n)
                .toList();
    }

    @Override
    public String toString() {
        return "DeathCauseStatisticList{" +
                "statistics=" + statistics +
                '}';
    }
}
