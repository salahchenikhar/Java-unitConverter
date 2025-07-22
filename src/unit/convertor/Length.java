package unit.convertor;

public class Length extends unit{
    double m; // Meter
    double km; // Kilometer
    double cm; // Centimeter
    double mm; // Millimeter

    // US/Imperial Unit
    double mi; // Mile
    double ft; // Foot
    double in; // Inch
    double yd; // Yard

    public Length() {}

    public Length(double value, String unit) {
        this();
        switch (unit) {
            case "m": // From Meter
                m = value;
                km = value / 1000;
                cm = value * 100;
                mm = value * 1000;
                mi = value * 0.000621371;
                ft = value * 3.28084;
                in = value * 39.3701;
                yd = value * 1.09361;
                break;

            case "km": // From Kilometer
                km = value;
                m = value * 1000;
                cm = value * 100000;
                mm = value * 1000000;
                mi = value * 0.621371;
                ft = value * 3280.84;
                in = value * 39370.1;
                yd = value * 1093.61;
                break;

            case "cm": // From Centimeter
                cm = value;
                m = value / 100;
                km = value / 100000;
                mm = value * 10;
                mi = value * 0.00000621371;
                ft = value * 0.0328084;
                in = value * 0.393701;
                yd = value * 0.0109361;
                break;

            case "mm": // From Millimeter
                mm = value;
                m = value / 1000;
                km = value / 1000000;
                cm = value / 10;
                mi = value * 0.000000621371;
                ft = value * 0.00328084;
                in = value * 0.0393701;
                yd = value * 0.00109361;
                break;

            case "mi": // From Mile
                mi = value;
                m = value * 1609.34;
                km = value * 1.60934;
                cm = value * 160934;
                mm = value * 1609340;
                ft = value * 5280;
                in = value * 63360;
                yd = value * 1760;
                break;

            case "ft": // From Foot
                ft = value;
                m = value * 0.3048;
                km = value * 0.0003048;
                cm = value * 30.48;
                mm = value * 304.8;
                mi = value * 0.000189394;
                in = value * 12;
                yd = value * 0.333333;
                break;

            case "in": // From Inch
                in = value;
                m = value * 0.0254;
                km = value * 0.0000254;
                cm = value * 2.54;
                mm = value * 25.4;
                mi = value * 0.0000157828;
                ft = value * 0.0833333;
                yd = value * 0.0277778;
                break;

            case "yd": // From Yard
                yd = value;
                m = value * 0.9144;
                km = value * 0.0009144;
                cm = value * 91.44;
                mm = value * 914.4;
                mi = value * 0.000568182;
                ft = value * 3;
                in = value * 36;
                break;

            default:
                m = 0;
                km = 0;
                cm = 0;
                mm = 0;
                mi = 0;
                ft = 0;
                in = 0;
                yd = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "m":
                return m;
            case "km":
                return km;
            case "cm":
                return cm;
            case "mm":
                return mm;
            case "mi":
                return mi;
            case "ft":
                return ft;
            case "in":
                return in; 
            case "yd":
                return yd;
            default:
                return 0.0;
        }
    }
}
 
