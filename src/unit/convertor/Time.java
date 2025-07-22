package unit.convertor;

public class Time extends unit {
    double seconds;
    double minutes;
    double hours;
    double days;
    double months;
    double years;

    public Time() {}

    public Time(double value, String unit) {
        this();
        switch (unit) {
            case "s":
                seconds = value;
                minutes = value / 60;
                hours = value / 3600;
                days = value / 86400;
                months = value / (30.44 * 86400);
                years = value / (365.25 * 86400);
                break;

            case "min":
                minutes = value;
                seconds = value * 60;
                hours = value / 60;
                days = value / 1440;
                months = value / (30.44 * 1440);
                years = value / (365.25 * 1440);
                break;

            case "h":
                hours = value;
                seconds = value * 3600;
                minutes = value * 60;
                days = value / 24;
                months = value / (30.44 * 24);
                years = value / (365.25 * 24);
                break;

            case "day":
                days = value;
                seconds = value * 86400;
                minutes = value * 1440;
                hours = value * 24;
                months = value / 30.44;
                years = value / 365.25;
                break;

            case "month":
                months = value;
                seconds = value * 30.44 * 86400;
                minutes = value * 30.44 * 1440;
                hours = value * 30.44 * 24;
                days = value * 30.44;
                years = value / 12;
                break;

            case "year":
                years = value;
                seconds = value * 365.25 * 86400;
                minutes = value * 365.25 * 1440;
                hours = value * 365.25 * 24;
                days = value * 365.25;
                months = value * 12;
                break;

            default:
                seconds = 0;
                minutes = 0;
                hours = 0;
                days = 0;
                months = 0;
                years = 0;
                break;
        }
    }

    public double getter(String unit) {
        switch (unit) {
            case "s":
                return seconds;
            case "min":
                return minutes;
            case "h":
                return hours;
            case "day":
                return days;
            case "month":
                return months;
            case "year":
                return years;
            default:
                return 0.0;
        }
    }
}
