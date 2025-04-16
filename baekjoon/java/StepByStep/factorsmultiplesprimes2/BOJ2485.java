package StepByStep.factorsmultiplesprimes2;

import java.io.*;

public class BOJ2485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] streetTree = new int[N];

        for (int i = 0; i < N; i++) {
            streetTree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = streetTree[1] - streetTree[0];

        for (int i = 2; i < N; i++) {
            gcd = gcd(gcd, streetTree[i] - streetTree[i - 1]);
        }

        int cnt = 0;

        for (int i = 0; i < N - 1; i++) {
            cnt += (streetTree[i + 1] - streetTree[i]) / gcd - 1;
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
