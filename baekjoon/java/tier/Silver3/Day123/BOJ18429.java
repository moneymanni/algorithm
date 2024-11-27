package Silver3.Day123;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18429 {
    static int N, K, cnt;
    static int[] arr, nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        DFS(0);

        bw.write(cnt+"");

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int depth) {
        if (depth == N) {
            int bigThree = 500;
            for (int i = 0; i < N; i++) {
                bigThree += arr[i] - K;

                if (bigThree < 500)
                    return;
            }
            cnt++;
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
