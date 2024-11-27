package Gold4.Day190;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11054 {

    private static int N;
    private static int[] A;
    private static int[] rightDp, leftDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        bw.write(solve() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int solve() {
        LIS();
        LDS();

        int max = 0;

        for (int i = 1; i <= N; i++)
            max = Math.max(max, rightDp[i] + leftDp[i]);

        return max - 1;
    }

    private static void LIS() {
        rightDp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            rightDp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (A[j] < A[i] && rightDp[i] < rightDp[j] + 1)
                    rightDp[i] = rightDp[j] + 1;
            }
        }
    }

    private static void LDS() {
        leftDp = new int[N + 1];

        for (int i = N; i > 0; i--) {
            leftDp[i] = 1;

            for (int j = N; j > i; j--) {
                if (A[j] < A[i] && leftDp[i] < leftDp[j] + 1)
                    leftDp[i] = leftDp[j] + 1;
            }
        }
    }
}
