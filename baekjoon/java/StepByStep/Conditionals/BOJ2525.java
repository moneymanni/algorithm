package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        Time currTime = new Time(A, B);
        Time ovenEndTime = Oven.runOven(currTime, C);

        System.out.printf("%d %d\n", ovenEndTime.hours, ovenEndTime.minutes);
    }

    private static class Oven {

        public static Time runOven(Time currTime, int ovenMinutes) {
            int totalMinutes = (currTime.hours * 60) + currTime.minutes;
            totalMinutes += ovenMinutes;

            return new Time(totalMinutes / 60 % 24, totalMinutes % 60);
        }
    }

    private static class Time {

        int hours;
        int minutes;

        public Time(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }
}
