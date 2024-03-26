package Silver4.Day97;

import java.io.*;

public class BOJ2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(br.readLine());

        int gcd = trees[1] - trees[0];
        for (int i = 2; i < N; i++)
            gcd = gcd(gcd, trees[i] - trees[i-1]);

        int cnt = 0;
        for (int i = 0; i < N - 1; i++)
            cnt += (trees[i+1] - trees[i]) / gcd - 1;

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
