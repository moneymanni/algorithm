package StepByStep.Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25206 {

    private static final int MAJOR_COURSE_COUNT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double result = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < MAJOR_COURSE_COUNT; i++) {
            st = new StringTokenizer(br.readLine());

            String CourseName = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            result += credit * gradeToPoint(grade);
            totalCredits += credit;
        }

        if (result != 0) {
            result /= totalCredits;
        }

        System.out.printf("%.6f", result);

        br.close();
    }

    private static double gradeToPoint(String grade) {
        double point = 0.0;

        switch (grade) {
            case "A+": point = 4.5; break;
            case "A0": point = 4.0; break;
            case "B+": point = 3.5; break;
            case "B0": point = 3.0; break;
            case "C+": point = 2.5; break;
            case "C0": point = 2.0; break;
            case "D+": point = 1.5; break;
            case "D0": point = 1.0; break;
            case "F": point = 0.0; break;
        }

        return point;
    }
}
