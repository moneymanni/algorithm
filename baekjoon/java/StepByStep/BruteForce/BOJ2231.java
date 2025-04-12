package StepByStep.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = getMinConstructor(N);

        System.out.println(result);

        br.close();
    }

    private static int getMinConstructor(int num) {
        for (int i = 1; i < num; i++) {
            String numStr = String.valueOf(i);

            int sum = i;

            for (int j = 0; j < numStr.length(); j++) {
                sum += numStr.charAt(j) - '0';
            }

            if (sum == num) {
                return i;
            }
        }

        return 0;
    }
}
