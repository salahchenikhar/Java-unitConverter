package unit.convertor;

public class Area extends unit{
    double km2;  // Square kilometer
    double ha;   // Hectare
    double m2;   // Square meter
    double mi2;  // Square mile
    double acres;// Acres
    double ft2;  // Square foot

    public Area() {}

    public Area(double value, String unit) {
        this();
        switch (unit) {
            case "Km²":
                km2 = value;
                ha = value * 100;
                m2 = value * 1_000_000;
                mi2 = value * 0.386102;
                acres = value * 247.105;
                ft2 = value * 10_763_910.4;
                break;

            case "ha":
                ha = value;
                km2 = value / 100;
                m2 = value * 10_000;
                mi2 = value * 0.00386102;
                acres = value * 2.47105;
                ft2 = value * 107_639.104;
                break;

            case "m²":
                m2 = value;
                km2 = value / 1_000_000;
                ha = value / 10_000;
                mi2 = value * 0.000000386102;
                acres = value * 0.000247105;
                ft2 = value * 10.7639;
                break;

            case "mi²":
                mi2 = value;
                km2 = value * 2.58999;
                ha = value * 258.999;
                m2 = value * 2_589_990;
                acres = value * 640;
                ft2 = value * 27_878_400;
                break;

            case "acres":
                acres = value;
                km2 = value * 0.00404686;
                ha = value * 0.404686;
                m2 = value * 4_046.86;
                mi2 = value * 0.0015625;
                ft2 = value * 43_560;
                break;

            case "ft²":
                ft2 = value;
                km2 = value / 10_763_910.4;
                ha = value / 107_639.104;
                m2 = value / 10.7639;
                mi2 = value / 27_878_400;
                acres = value / 43_560;
                break;

            default:
                km2 = 0;
                ha = 0;
                m2 = 0;
                mi2 = 0;
                acres = 0;
                ft2 = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "Km²": 
                return km2;
            case "ha": 
                return ha;
            case "m²": 
                return m2;
            case "mi²": 
                return mi2;
            case "acres": 
                return acres;
            case "ft²": 
                return ft2;
            default: return 0.0;
        }
    }
}
