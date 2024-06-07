package Silver2.Day137;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15665 {
    private static int N, M;
    private static int[] nums, arr;
    private static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        arr = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        DFS(0);

        for (String str : set)
            bw.write(str + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++)
                sb.append(arr[i]).append(' ');

            set.add(sb.toString().trim());

            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = nums[i];
            DFS(depth + 1);
        }
    }
}
