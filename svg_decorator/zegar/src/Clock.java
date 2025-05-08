import java.time.LocalTime;

public abstract class Clock {
    private int hour;
    private int minute;
    private int second;

    public void setCurrentTime() {
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Godzina poza zakresem 0-23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minuta poza zakresem 0-59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Sekunda poza zakresem 0-59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
