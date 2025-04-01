package StepByStep.OneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3052 {

    private static final int MOD = 42;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[MOD];

        for (int i = 1; i <= 10; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[num % MOD]++;
        }

        int cnt = 0;

        for (int i = 0; i < MOD; i++) {
            if (arr[i] != 0) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}
