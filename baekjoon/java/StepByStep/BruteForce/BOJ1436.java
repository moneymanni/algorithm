package StepByStep.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        String str = "";

        while (N > 0) {
            str = String.valueOf(idx);

            if (str.contains("666")) {
                N--;
            }

            idx++;
        }

        System.out.println(str);

        br.close();
    }
}
