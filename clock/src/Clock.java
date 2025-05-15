import java.time.LocalTime;

public abstract class Clock {
    private LocalTime time;

    public void setCurrentTime() {
        this.time = LocalTime.now();
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Godzina spoza zakresu (0-23): " + hour);
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Minuta spoza zakresu (0-59): " + minute);
        if (second < 0 || second > 59)
            throw new IllegalArgumentException("Sekunda spoza zakresu (0-59): " + second);

        this.time = LocalTime.of(hour, minute, second);
    }

    @Override
    public String toString() {
        return time.toString();
    }
}
