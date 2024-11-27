package Gold5.Day177;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                coin[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());

            int result = func(coin, M);

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int func(int[] coin, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= amount; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        return dp[amount];
    }
}
