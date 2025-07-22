package unit.convertor;

public class Conversion {

    private final double inValue;
    private final double outValue;
    private final String inUnit;
    private final String outUnit;

    public Conversion(double inValue, double outValue, String inUnit, String outUnit) {
        this.inValue = inValue;
        this.outValue = outValue;
        this.inUnit = inUnit;
        this.outUnit = outUnit;
    }

    public Conversion(String line) {
        // Expected format: "1.50 m → 150.00 cm"
        String[] parts = line.split("→");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format");
        }

        String[] left = parts[0].trim().split(" ");
        String[] right = parts[1].trim().split(" ");

        if (left.length != 2 || right.length != 2) {
            throw new IllegalArgumentException("Invalid format");
        }

        this.inValue = Double.parseDouble(left[0].replace(',', '.'));
        this.inUnit = left[1];
        this.outValue = Double.parseDouble(right[0].replace(',', '.'));
        this.outUnit = right[1];
    }

    public double getInValue() {
        return inValue;
    }

    public double getOutValue() {
        return outValue;
    }

    public String getInUnit() {
        return inUnit;
    }

    public String getOutUnit() {
        return outUnit;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s → %.2f %s", inValue, inUnit, outValue, outUnit);
    }
}
