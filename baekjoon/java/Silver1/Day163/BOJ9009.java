package Silver1.Day163;

import java.io.*;
import java.util.*;

public class BOJ9009 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        fibonacci(45);  // 1_134_903_170

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> list = find(n);

            for (Integer num : list)
                sb.append(num).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Integer> find(int num) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;

        while (dp[idx] <= num) idx++;
        
        for (; idx >= 0; idx--) {
            if (num == 0) break;
            
            if (num >= dp[idx]) {
                list.add(dp[idx]);
                num -= dp[idx];
            }
        }

        Collections.sort(list);

        return list;
    }

    private static void fibonacci(int num) {
        dp = new int[num + 1];

        if (num >= 0) dp[0] = 0;
        if (num >= 1) dp[1] = 1;

        for (int i = 2; i <= num; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
    }
}
