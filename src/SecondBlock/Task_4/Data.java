package SecondBlock.Task_4;

public class Data {

    private int day;
    private int month;
    private int year;

    public Data(int day, int month, int year) {
        if (year < 0 | month <= 0 | month > 12 | day <= 0) {
            throw new IllegalArgumentException();
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    throw new IllegalArgumentException();
                }
                break;
            case 2:
                if (day > 28) {
                    if (day < 30) {
                        if (!isLeap(year)) {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                break;
            default:
                if (day > 31) {
                    throw new IllegalArgumentException();
                }
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    public void nextDay() {
        day++;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    month++;
                    day = 1;
                }
                break;
            case 2:
                if (day > 28) {
                    if (day < 30) {
                        if (!isLeap(year)) {
                            month++;
                            day = 1;
                        }
                    } else {
                        month++;
                        day = 1;
                    }
                }
                break;
            case 12:
                if (day > 31) {
                    day = 1;
                    month = 1;
                    year++;
                }
                break;
            default:
                if (day > 31) {
                    month++;
                    day = 1;
                }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
