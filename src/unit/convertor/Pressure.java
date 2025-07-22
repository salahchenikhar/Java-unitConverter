package unit.convertor;

public class Pressure extends unit{
    private double bar;  // Bar
    private double pa;   // Pascal
    private double atm;  // Atmosphere
    private double psi;  // Pounds per square inch (psi)

    public Pressure() {}

    public Pressure(double value, String unit) {
        this();
        switch (unit) {
            case "bar":
                bar = value;
                pa = value * 100_000;
                atm = value / 1.01325;
                psi = value * 14.5038;
                break;

            case "pa":
                pa = value;
                bar = value / 100_000;
                atm = value / 101_325;
                psi = value * 0.000145;
                break;

            case "atm":
                atm = value;
                bar = value * 1.01325;
                pa = value * 101_325;
                psi = value * 14.6959;
                break;

            case "psi":
                psi = value;
                bar = value / 14.5038;
                pa = value / 0.000145;
                atm = value / 14.6959;
                break;

            default:
                bar = 0;
                pa = 0;
                atm = 0;
                psi = 0;
                break;
        }
    }

    public double getter (String unit) {
        switch (unit) {
            case "bar": 
                return bar;
            case "pa": 
                return pa;
            case "atm": 
                return atm;
            case "psi": 
                return psi;
            default: return 0.0;
        }
    }
}
