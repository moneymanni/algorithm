package StepByStep.OneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5597 {

    private static final int NUM_OF_STUDENTS = 30;
    private static final int UNSUBMITTED_STUDENT_COUNT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] submitted = new boolean[NUM_OF_STUDENTS + 1];

        for (int i = 1; i <= NUM_OF_STUDENTS - UNSUBMITTED_STUDENT_COUNT; i++) {
            int n = Integer.parseInt(br.readLine());

            submitted[n] = true;
        }

        for (int i = 1, cnt = 0; i < submitted.length && UNSUBMITTED_STUDENT_COUNT != cnt; i++) {
            if (!submitted[i]) {
                System.out.println(i);
                cnt++;
            }
        }

        br.close();
    }
}
