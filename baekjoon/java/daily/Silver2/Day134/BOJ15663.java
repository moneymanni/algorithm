package Silver2.Day134;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    private static int N, M;
    private static int[] arr, nums;
    private static boolean[] visited;
    private static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        arr = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        DFS(0);

        for (String s : set)
            bw.write(s + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr)
                sb.append(i).append(' ');

            set.add(sb.toString().trim());

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
