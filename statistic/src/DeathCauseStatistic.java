import java.util.Arrays;

public class DeathCauseStatistic {
    private String idc10;
    private int[] deaths;

    public static DeathCauseStatistic fromCsvLine (String line) {
        DeathCauseStatistic statistic = new DeathCauseStatistic();
        String[] parts = line.split(",", -1);
        statistic.idc10 = parts[0];
        statistic.idc10 = statistic.idc10.trim();
        statistic.deaths = new int[20];
        for(int i = 0; i < 20; i++) {
            if (parts[i + 2].equals("-")) {
                statistic.deaths[i] = 0;
            } else {
                statistic.deaths[i] = Integer.parseInt(parts[i + 2]);
            }
        }
        return statistic;
    }

    public class AgeBracketDeaths {
        public final int young, old, deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }

    public AgeBracketDeaths getDeathCount(int age) {
        int index = age / 5;
        if (index >= 20 ) {
            index = 19;
        }
        return new AgeBracketDeaths(index * 5, index * 5 + 4, this.deaths[index]);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "idc10='" + idc10 + '\'' +
                ", deaths=" + Arrays.toString(deaths) +
                '}';
    }
}
