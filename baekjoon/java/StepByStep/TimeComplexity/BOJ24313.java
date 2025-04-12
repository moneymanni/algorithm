package StepByStep.TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        System.out.println(checkBigO(a1, a0, c, n0) ? 1 : 0);

        br.close();
    }

    private static boolean checkBigO(int a1, int a0, int c, int n0) {
        for (int n = n0; n <= 100; n++) {
            if (!(a1 * n + a0 <= c * n)) {
                return false;
            }
        }

        return true;
    }
}
