import java.time.LocalTime;

public abstract class Clock {
    protected LocalTime time;
    private City city;

    public Clock(City city) {
        this.city = city;
        setCurrentTime();
    }

    public void setCurrentTime() {
        this.time = LocalTime.now();
        time = time.plusHours(city.getTimeZone());
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

    public void setCity(City newCity) {
        int offset = newCity.getTimeZone() - this.city.getTimeZone();
        this.city = newCity;
        this.time = this.time.plusHours(offset);
    }

    @Override
    public String toString() {
        return time.toString();
    }
}
