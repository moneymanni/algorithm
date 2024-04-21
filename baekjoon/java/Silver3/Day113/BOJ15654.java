package Silver3.Day113;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int N, M;
    static int[] arr, nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N+1];
        for (int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        arr = new int[M];
        visited = new boolean[N+1];

        DFS(0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int num : arr)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
