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
        if (mode == Mode.H24) {
            return super.toString();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
            return time.format(formatter);
        }
    }
}
