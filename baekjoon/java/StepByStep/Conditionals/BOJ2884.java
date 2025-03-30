package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ2884 {

    private static final int ALARM_OFFSET_MINUTES = 45;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        Alarm alarm = new Alarm(new Time(H, M));
        Time time = alarm.setAlarm(ALARM_OFFSET_MINUTES);

        System.out.printf("%d %d\n", time.getHours(), time.getMinutes());
    }

    private static class Alarm {

        private Time time;

        public Alarm(Time time) {
            this.time = time;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public Time setAlarm(int alarmOffsetMinutes) {
            int alarm = (time.getHours() * 60) + time.getMinutes();
            alarm -= alarmOffsetMinutes;

            if (alarm < 0) {
                alarm += Time.TOTAL_MINUTES_IN_DAY;
            }

            return new Time(alarm / 60, alarm % 60);
        }
    }

    private static class Time {

        static final int TOTAL_MINUTES_IN_DAY = 1_440;

        private int hours;
        private int minutes;

        public Time(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
    }
}
