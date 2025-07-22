package unit.convertor;

public class Energy extends unit {
    private double J;    // Joule
    private double kWh;  // Kilowatt-hour
    private double cal;  // Calorie
    private double BTU;  // British Thermal Unit

    public Energy() {}

    public Energy(double value, String unit) {
        this();
        switch (unit) {
            case "J": // From Joule
                J = value;
                kWh = value / 3_600_000;
                cal = value * 0.239;
                BTU = value / 1055.06;
                break;

            case "KWH": // From Kilowatt-hour
                kWh = value;
                J = value * 3_600_000;
                cal = J * 0.239;
                BTU = J / 1055.06;
                break;

            case "cal": // From Calorie
                cal = value;
                J = value / 0.239;
                kWh = J / 3_600_000;
                BTU = J / 1055.06;
                break;

            case "BTU": // From British Thermal Unit
                BTU = value;
                J = value * 1055.06;
                kWh = J / 3_600_000;
                cal = J * 0.239;
                break;

            default:
                J =0;
                kWh = 0;
                cal = 0;
                BTU = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "J": 
                return J;
            case "KWH": 
                return kWh;
            case "cal": 
                return cal;
            case "BTU": 
                return BTU;
            default: return 0.0;
        }
    }
}
