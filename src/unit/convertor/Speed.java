package unit.convertor;

public class Speed extends unit{
    private double mps;   // Meters per second
    private double kmph;  // Kilometers per hour
    private double mph;   // Miles per hour
    private double fps;   // Feet per second
    private double knots; // Knots

    public Speed() {}

    public Speed(double value, String unit) {
        this();
        switch (unit) {
            case "mps": // Meters per second
                mps = value;
                kmph = value * 3.6;
                mph = value * 2.23694;
                fps = value * 3.28084;
                knots = value * 1.94384;
                break;

            case "kmph": // Kilometers per hour
                kmph = value;
                mps = value / 3.6;
                mph = value * 0.621371;
                fps = value * 0.911344;
                knots = value * 0.539957;
                break;

            case "mph": // Miles per hour
                mph = value;
                mps = value * 0.44704;
                kmph = value * 1.60934;
                fps = value * 1.46667;
                knots = value * 0.868976;
                break;

            case "fps": // Feet per second
                fps = value;
                mps = value * 0.3048;
                kmph = value * 1.09728;
                mph = value * 0.681818;
                knots = value * 0.592484;
                break;

            case "knots": // Knots
                knots = value;
                mps = value * 0.514444;
                kmph = value * 1.852;
                mph = value * 1.15078;
                fps = value * 1.68781;
                break;

            default:
                mps = 0;
                kmph = 0;
                mph = 0;
                fps = 0;
                knots = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "mps": 
                return mps;
            case "kmph": 
                return kmph;
            case "mph": 
                return mph;
            case "fps": 
                return fps;
            case "knots": 
                return knots;
            default: return 0.0;
        }
    }
}
