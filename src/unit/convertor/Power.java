package unit.convertor;

public class Power extends unit{
    private double W;      // Watt
    private double KW;     // Kilowatt
    private double hp;     // Horsepower
    private double BTU_h;  // BTU per hour

    public Power() {}

    public Power(double value, String unit) {
        this();
        switch (unit) {
            case "W": // From Watt
                W = value;
                KW = value / 1000;
                hp = value / 745.7;
                BTU_h = value * 3.412;
                break;

            case "KW": // From Kilowatt
                KW = value;
                W = value * 1000;
                hp = value * 1.341;
                BTU_h = value * 3412;
                break;

            case "hp": // From Horsepower
                hp = value;
                W = value * 745.7;
                KW = value * 0.7457;
                BTU_h = value * 2544.43;
                break;

            case "BTU/h": // From BTU per hour
                BTU_h = value;
                W = value / 3.412;
                KW = value / 3412;
                hp = value / 2544.43;
                break;

            default:
                W = 0;
                KW = 0;
                hp = 0;
                BTU_h = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "W": 
                return W;
            case "KW": 
                return KW;
            case "hp": 
                return hp;
            case "BTU/h": 
                return BTU_h;
            default: return 0.0;
        }
    }
}
