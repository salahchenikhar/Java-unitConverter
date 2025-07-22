package unit.convertor;

public class Temperature extends unit{
    double C; // Celsius
    double F; // Fahrenheit

    public Temperature() {}

    public Temperature(double value, String unit) {
        this();
        switch (unit) {
            case "C": // From Celsius
                C = value;
                F = (9.0 / 5.0 * value) + 32;
                break;

            case "F": // From Fahrenheit
                F = value;
                C = (value - 32) * 5.0 / 9.0;
                break;

            default:
                C = 0;
                F = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "C":
                return C;
            case "F":
                return F;
            default:
                return 0.0;
        }
    }
}
