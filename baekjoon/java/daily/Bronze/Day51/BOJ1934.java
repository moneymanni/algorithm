package Day51;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            int A = testCase[i][0];
            int B = testCase[i][1];

            bw.write(lcm(A, B) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}
