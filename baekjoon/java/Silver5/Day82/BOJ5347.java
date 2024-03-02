package Silver5.Day82;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] testCase = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int a = testCase[i][0];
            int b = testCase[i][1];

            long result = lcm(a, b);
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long gcd1 (int a, int b) {
        if (b == 0)
            return a;
        return gcd1(b, a % b);
    }

    private static long gcd2 (int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int num = a % b;
            a = b;
            b = num;
        }

        return a;
    }

    public static long lcm (int a, int b) {
        return ((long) a * b) / gcd1(a, b);
    }
}
