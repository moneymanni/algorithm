package StepByStep.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0;i  < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int value = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = card[i] + card[j] + card[k];

                    if (Math.abs(M - sum) < Math.abs(M - value) && sum <= M) {
                        value = sum;
                    }
                }
            }
        }

        System.out.println(value);

        br.close();
    }
}
