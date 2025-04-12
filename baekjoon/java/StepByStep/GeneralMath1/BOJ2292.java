package StepByStep.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 1;
        int value = 6;
        int idx = 1;

        while (N > max) {
            max += value;
            value += 6;
            idx++;
        }

        System.out.println(idx);

        br.close();
    }
}
