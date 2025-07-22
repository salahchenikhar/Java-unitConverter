package unit.convertor;

public class WeightMass extends unit {
    private double mg;   // Milligrams
    private double g;    // Grams
    private double kg;   // Kilograms
    private double oz;   // Ounces
    private double lb;   // Pounds
    private double ton;  // Short tons

    public WeightMass() {}

    public WeightMass(double value, String unit) {
        this();
        switch (unit)  {
            case "mg": // From Milligrams
                mg = value;
                g = value / 1_000;
                kg = g / 1_000;
                oz = g / 28.3495;
                lb = oz / 16;
                ton = lb / 2_000;
                break;

            case "g": // From Grams
                g = value;
                mg = g * 1_000;
                kg = g / 1_000;
                oz = g / 28.3495;
                lb = oz / 16;
                ton = lb / 2_000;
                break;

            case "kg": // From Kilograms
                kg = value;
                g = kg * 1_000;
                mg = g * 1_000;
                oz = g / 28.3495;
                lb = oz / 16;
                ton = lb / 2_000;
                break;

            case "oz": // From Ounces
                oz = value;
                g = oz * 28.3495;
                mg = g * 1_000;
                kg = g / 1_000;
                lb = oz / 16;
                ton = lb / 2_000;
                break;

            case "lb": // From Pounds
                lb = value;
                oz = lb * 16;
                g = oz * 28.3495;
                mg = g * 1_000;
                kg = g / 1_000;
                ton = lb / 2_000;
                break;

            case "ton": // From Short Tons
                ton = value;
                lb = ton * 2_000;
                oz = lb * 16;
                g = oz * 28.3495;
                mg = g * 1_000;
                kg = g / 1_000;
                break;

            default:
                mg = 0;
                g = 0;
                kg = 0;
                oz = 0;
                lb = 0;
                ton = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "mg": 
                return mg;
            case "g": 
                return g;
            case "kg": 
                return kg;
            case "oz": 
                return oz;
            case "lb": 
                return lb;
            case "ton": 
                return ton;
            default: return 0.0;
        }
    }
}
