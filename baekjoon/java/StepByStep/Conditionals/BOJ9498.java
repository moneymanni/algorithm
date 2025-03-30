package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ9498 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();

        String result = computeTestGrade(score);

        System.out.println(result);
    }

    private static String computeTestGrade(int score) {
        String grade = null;

        if (90 <= score && score <= 100) {
            grade = "A";
        } else if (80 <= score && score <= 89) {
            grade = "B";
        } else if (70 <= score && score <= 79) {
            grade = "C";
        } else if (60 <= score && score <= 69) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }
}
