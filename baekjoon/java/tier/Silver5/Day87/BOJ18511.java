package Silver5.Day87;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {
    public static int[] nums;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[K];
        for (int i = 0; i < K; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        dfs(N, K, 0);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs (int N, int K, int curr) {
        if (curr > N)
            return;

        if (result < curr)
            result = curr;

        for (int i = K - 1; i >= 0; i--)
            dfs(N, K, curr*10 + nums[i]);
    }
}
