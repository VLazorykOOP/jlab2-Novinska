/*Створити клас Time для роботи з часом у форматі «година:хвилина:секунда»
з трьома полями типу short. Клас повинен включати не менше чотирьох
конструкторів: ініціалізація числами, рядком, секундами та часом.
Обов’язковими операціями є: обчислення різниці між двома моментами часу у
секундах, додавання часу та заданої кількості секунд, віднімання з часу заданої
кількості секунд, порівняння моментів часу, перевід в секунди, перевід в
хвилини (з заокругленням до цілої хвилини).*/
class Time {
    private short hour;
    private short minute;
    private short second;

    // Конструктор для ініціалізації числами
    public Time(short hour, short minute, short second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Конструктор для ініціалізації з рядка у форматі "година:хвилина:секунда"
    public Time(String timeStr) {
        String[] parts = timeStr.split(":");
        if (parts.length == 3) {
            try {
                this.hour = Short.parseShort(parts[0]);
                this.minute = Short.parseShort(parts[1]);
                this.second = Short.parseShort(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format for time string.");
            }
        } else {
            System.out.println("Incorrect format for time string.");
        }
    }

    // Конструктор для ініціалізації з секунд
    public Time(int seconds) {
        this.hour = (short) (seconds / 3600);
        this.minute = (short) ((seconds % 3600) / 60);
        this.second = (short) (seconds % 60);
    }

    // Конструктор для ініціалізації з іншого об'єкта Time
    public Time(Time otherTime) {
        this.hour = otherTime.hour;
        this.minute = otherTime.minute;
        this.second = otherTime.second;
    }

    // Обчислити різницю між двома моментами часу у секундах
    public int getDifferenceInSeconds(Time otherTime) {
        int thisSeconds = this.hour * 3600 + this.minute * 60 + this.second;
        int otherSeconds = otherTime.hour * 3600 + otherTime.minute * 60 + otherTime.second;
        return Math.abs(thisSeconds - otherSeconds);
    }

    // Додати задану кількість секунд до часу
    public Time addSeconds(int seconds) {
        int totalSeconds = this.hour * 3600 + this.minute * 60 + this.second + seconds;
        this.hour = (short) (totalSeconds / 3600);
        this.minute = (short) ((totalSeconds % 3600) / 60);
        this.second = (short) (totalSeconds % 60);
        return new Time(hour, minute, second);
    }

    // Відняти задану кількість секунд від часу
    public void subtractSeconds(int seconds) {
        int totalSeconds = this.hour * 3600 + this.minute * 60 + this.second - seconds;
        if (totalSeconds < 0) {
            totalSeconds = 0;
        }
        this.hour = (short) (totalSeconds / 3600);
        this.minute = (short) ((totalSeconds % 3600) / 60);
        this.second = (short) (totalSeconds % 60);
    }

    // Перевести час в секунди
    public int toSeconds() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    // Перевести час в хвилини з заокругленням до цілої хвилини
    public int toMinutes() {
        return (int) Math.ceil(this.toSeconds() / 60.0);
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}


public class TimeDiff {
    public static void main(String[] args) {
        Time time1 = new Time((short) 12, (short) 30, (short) 45);
        Time time2 = new Time("10:15:30");
        Time time3 = new Time(3723); // (1:2:3)

        System.out.println("Time 1: " + time1.toString());
        System.out.println("Time 2: " + time2.toString());
        System.out.println("Time 3: " + time3.toString());

        int differenceInSeconds = time1.getDifferenceInSeconds(time2);
        System.out.println("Difference in seconds between Time 1 and Time 2: " + differenceInSeconds + " seconds");

        time1.addSeconds(3600); // Додамо годину до Time 1
        System.out.println("Time 1 after adding 1 hour: " + time1.toString());

        time2.subtractSeconds(1800); // Віднімемо 30 хвилин від Time 2
        System.out.println("Time 2 after subtracting 30 minutes: " + time2.toString());

        int time2Minutes = time2.toMinutes();
        System.out.println("Time 2 in minutes: " + time2Minutes + " minutes");
    }
}
