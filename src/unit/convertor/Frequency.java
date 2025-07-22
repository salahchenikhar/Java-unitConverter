package unit.convertor;

public class Frequency extends unit {
    private double hz;   // Hertz
    private double cps;  // Cycles per second

    public Frequency() {}

    public Frequency(double value, String unit) {
        this();
        switch (unit) {
            case "HZ": // From Hertz
                hz = value;
                cps = value; // 1 Hertz = 1 cycle per second
                break;

            case "cycle/s": // From Cycles per second
                cps = value;
                hz = value; // 1 cycle per second = 1 Hertz
                break;

            default:
                hz = 0;
                cps= 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "HZ": 
                return hz;
            case "cycle/s": 
                return cps;
            default: return 0.0;
        }
    }
}
