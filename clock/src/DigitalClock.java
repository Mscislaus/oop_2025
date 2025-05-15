import java.time.format.DateTimeFormatter;

public class DigitalClock extends Clock {
    public enum Mode {
        H12, H24
    }

    private Mode mode;

    public DigitalClock(Mode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter;
        if (mode == Mode.H24) {
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        } else {
            formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
        }
        return time.format(formatter);
    }
}
