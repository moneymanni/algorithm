package Silver1.Day167;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10166 {
    private static boolean[][] show = new boolean[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D1 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());

        long result = 0;

        for (int i = D1; i <= D2; i++) {
            for (int j = 1; j <= i; j++) {
                int gcd = getGCD(i, j);

                if (show[i / gcd][j / gcd])
                    continue;

                result++;
                show[i / gcd][j / gcd] = true;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
