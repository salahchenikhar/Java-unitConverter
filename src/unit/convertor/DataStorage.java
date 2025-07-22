package unit.convertor;

public class DataStorage extends unit {
    private double B;     // Byte
    private double b;     // Bit
    private double KB;    // kiloByte
    private double Kb;    // kiloBit
    private double MB;    // megaByte
    private double Mb;    // megaBit
    private double GB;    // gigaByte
    private double Gb;    // gigaBit
    private double TB;    // teraByte
    private double Tb;    // teraBit
    private double PB;    // petaByte
    private double Pb;    // petaBit

    public DataStorage() {}

    public DataStorage(double value, String unit) {
        this();
        switch (unit) {
            case "Byte": // From byte
                B = value;
                b = B * 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "bit": // From bit
                b = value;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "KB": // From kiloByte
                KB = value;
                B = KB * 1024;
                b = B * 8;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "Kb": // From kiloBit
                Kb = value;
                b = Kb * 1000;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "MB": // From megaByte
                MB = value;
                KB = MB * 1024;
                B = KB * 1024;
                b = B * 8;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "Mb": // From megaBit
                Mb = value;
                Kb = Mb * 1000;
                b = Kb * 1000;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "GB": // From gigaByte
                GB = value;
                MB = GB * 1024;
                KB = MB * 1024;
                B = KB * 1024;
                b = B * 8;
                TB = GB / 1024;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "Gb": // From gigaBit
                Gb = value;
                Mb = Gb * 1000;
                Kb = Mb * 1000;
                b = Kb * 1000;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "TB": // From teraByte
                TB = value;
                GB = TB * 1024;
                MB = GB * 1024;
                KB = MB * 1024;
                B = KB * 1024;
                b = B * 8;
                PB = TB / 1024;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "Tb": // From teraBit
                Tb = value;
                Kb = Mb * 1000;
                Gb = Tb * 1000;
                Mb = Gb * 1000;
                b = Kb * 1000;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                Pb = Tb / 1000;
                break;

            case "PB": // From petaByte
                PB = value;
                TB = PB * 1024;
                GB = TB * 1024;
                MB = GB * 1024;
                KB = MB * 1024;
                B = KB * 1024;
                b = B * 8;
                Kb = b / 1000;
                Mb = Kb / 1000;
                Gb = Mb / 1000;
                Tb = Gb / 1000;
                Pb = Tb / 1000;
                break;

            case "Pb": // From petaBit
                Pb = value;
                Tb = Pb * 1000;
                Gb = Tb * 1000;
                Mb = Gb * 1000;
                Kb = Mb * 1000;
                b = Kb * 1000;
                B = b / 8;
                KB = B / 1024;
                MB = KB / 1024;
                GB = MB / 1024;
                TB = GB / 1024;
                PB = TB / 1024;
                break;

            default:
                // Invalid unit
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "Byte": return B;
            case "bit": return b;
            case "KB": return KB;
            case "MB": return MB;
            case "GB": return GB;
            case "TB": return TB;
            case "PB": return PB;
            case "Kb": return Kb;
            case "Mb": return Mb;
            case "Gb": return Gb;
            case "Tb": return Tb;
            case "Pb": return Pb;
            default: return 0.0;
        }
    }
}
