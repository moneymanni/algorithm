package StepByStep.FactorsMultiplesPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;

        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (isFactor(A, B)) {
                System.out.println("factor");
            } else if (isMultiple(A, B)) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }

        br.close();
    }

    private static boolean isMultiple(int a, int b) {
        return a % b == 0;
    }

    private static boolean isFactor(int a, int b) {
        return b % a == 0;
    }
}
