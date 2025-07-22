package unit.convertor;

public class Volume extends unit {
    double L; // Liter
    double m3; // cubic meter
    double mL; // milliliter
    double cm3; // cubic centimeter

    // US/Imperial Unit
    double usGal; // US gallon
    double usFlOz; // US fluid ounce
    double ft3; // cubic foot
    double in3; // cubic inch

    // UK/Imperial Unit
    double ukGal; // UK gallon
    double ukFlOz; // UK fluid ounce

    public Volume(){}

    public Volume(double value, String unit) {
        this();
        switch (unit) {
            case "L": // From Liter
                L = value;
                m3 = value / 1000;
                mL = value * 1000;
                cm3 = value * 1000;
                usGal = value * 0.264172;
                usFlOz = value * 33.814;
                ft3 = value * 0.0353147;
                in3 = value * 61.0237;
                ukGal = value * 0.219969;
                ukFlOz = value * 35.1951;
                break;

            case "m³": // From cubic meter
                m3 = value;
                L = value * 1000;
                mL = value * 1_000_000;
                cm3 = value * 1_000_000;
                usGal = value * 264.172;
                usFlOz = value * 33_814;
                ft3 = value * 35.3147;
                in3 = value * 61_023.7;
                ukGal = value * 219.969;
                ukFlOz = value * 35_195.1;
                break;

            case "mL": // From milliliter
                mL = value;
                L = value / 1000;
                m3 = value / 1_000_000;
                cm3 = value;
                usGal = value * 0.000264172;
                usFlOz = value * 0.033814;
                ft3 = value * 0.0000353147;
                in3 = value * 0.0610237;
                ukGal = value * 0.000219969;
                ukFlOz = value * 0.0351951;
                break;

            case "cm³": // From cubic centimeter
                cm3 = value;
                L = value / 1000;
                m3 = value / 1_000_000;
                mL = value;
                usGal = value * 0.000264172;
                usFlOz = value * 0.033814;
                ft3 = value * 0.0000353147;
                in3 = value * 0.0610237;
                ukGal = value * 0.000219969;
                ukFlOz = value * 0.0351951;
                break;

            case "usGal": // From US gallon
                usGal = value;
                L = value * 3.78541;
                m3 = value * 0.00378541;
                mL = value * 3_785.41;
                cm3 = value * 3_785.41;
                usFlOz = value * 128;
                ft3 = value * 0.133681;
                in3 = value * 231;
                ukGal = value * 0.832674;
                ukFlOz = value * 133.227;
                break;

            case "usFlOz": // From US fluid ounce
                usFlOz = value;
                L = value * 0.0295735;
                m3 = value * 0.0000295735;
                mL = value * 29.5735;
                cm3 = value * 29.5735;
                usGal = value / 128;
                ft3 = value * 0.000957506;
                in3 = value * 1.80469;
                ukGal = value * 0.00650527;
                ukFlOz = value * 1.04084;
                break;

            case "ft³": // From cubic foot
                ft3 = value;
                L = value * 28.3168;
                m3 = value * 0.0283168;
                mL = value * 28_316.8;
                cm3 = value * 28_316.8;
                usGal = value * 7.48052;
                usFlOz = value * 957.506;
                in3 = value * 1728;
                ukGal = value * 6.22884;
                ukFlOz = value * 996.613;
                break;

            case "in³": // From cubic inch
                in3 = value;
                L = value * 0.0163871;
                m3 = value * 0.0000163871;
                mL = value * 16.3871;
                cm3 = value * 16.3871;
                usGal = value * 0.004329;
                usFlOz = value * 0.554113;
                ft3 = value * 0.000578704;
                ukGal = value * 0.00360465;
                ukFlOz = value * 0.576731;
                break;

            case "ukGal": // From UK gallon
                ukGal = value;
                L = value * 4.54609;
                m3 = value * 0.00454609;
                mL = value * 4_546.09;
                cm3 = value * 4_546.09;
                usGal = value * 1.20095;
                usFlOz = value * 153.722;
                ft3 = value * 0.160544;
                in3 = value * 277.419;
                ukFlOz = value * 160;
                break;

            case "ukFlOz": // From UK fluid ounce
                ukFlOz = value;
                L = value * 0.0284131;
                m3 = value * 0.0000284131;
                mL = value * 28.4131;
                cm3 = value * 28.4131;
                usGal = value * 0.00650527;
                usFlOz = value * 1.04084;
                ft3 = value * 0.000996613;
                in3 = value * 1.73387;
                ukGal = value / 160;
                break;

            default:
                L = 0;
                m3 = 0;
                mL = 0;
                cm3 = 0;
                usGal = 0;
                usFlOz = 0;
                ft3 = 0;
                in3 = 0;
                ukGal = 0;
                ukFlOz = 0;
                break;

        }
    }

    public double getter (String unit){
        switch (unit){
            case "L" :
                return L;
            case "m³" :
                return m3;
            case "mL" :
                return mL;
            case "cm³" :
                return cm3;
            case "usGal" :
                return usGal;
            case "usFlOz":
                return usFlOz;
            case "ft³" :
                return ft3;
            case "in³" :
                return in3;
            case "ukGal" :
                return ukGal;
            case "ukFlOz" :
                return ukFlOz;
            default:
                return 0.0;
        }
    }
}
