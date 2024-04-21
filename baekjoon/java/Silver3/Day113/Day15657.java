package Silver3.Day113;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day15657 {
    static int N, M;
    static int[] arr, nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        nums = new int[M];

        DFS(1, 0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int at, int depth) {
        if (depth == M) {
            for (int num : nums)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            nums[depth] = arr[i];
            DFS(i, depth+1);
        }
    }
}
