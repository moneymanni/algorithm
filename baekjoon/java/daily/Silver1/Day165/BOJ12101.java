package Silver1.Day165;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12101 {
    private static int[] NUMS = new int[]{1, 2, 3};
    private static int n, k;
    private static int len;
    private static int[] cases = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        search(0, 0);

        StringBuilder sb = new StringBuilder();

        if (k != 0) {
            sb.append(-1);
        } else {
            for (int i = 0; i < len; i++)
                sb.append(cases[i]).append('+');
            sb.deleteCharAt(sb.length() - 1);
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void search (int sum, int depth) {
        if (sum == n) {
            k--;
            len = depth;
            return;
        }

        for (int i = 0; i < NUMS.length; i++) {
            if (sum + NUMS[i] > n || k == 0)
                break;

            cases[depth] = NUMS[i];
            search(sum + NUMS[i], depth + 1);
        }
    }
}
