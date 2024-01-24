package Day43;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2702 {
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
            int a = testCase[i][0];
            int b = testCase[i][1];

            int max = Math.max(a, b);
            int min = Math.min(a, b);

            int gcdNum = gcd(max, min);
            int lcmNum = lcm(max, min, gcdNum);
            bw.write(String.format("%d %d\n", lcmNum, gcdNum));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int gcd (int a, int b) {  // 최대공약수
        if (b == 0)
            return Math.abs(a);

        return gcd(b, a % b);
    }

    public static int lcm (int a, int b, int gcd) {  // 최소공배수
        return a * b / gcd;
    }
}
