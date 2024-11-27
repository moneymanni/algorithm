package Silver1.Day166;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16943 {
    private static int A, B;
    private static int result;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String inputA = st.nextToken();
        A = Integer.parseInt(inputA);
        B = Integer.parseInt(st.nextToken());

        arr = new int[inputA.length()];
        visited = new boolean[inputA.length()];
        result = -1;

        for (int i = 0; i < arr.length; i++)
            arr[i] = inputA.charAt(i) - '0';

        DFS(0, 0);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int num, int depth) {
        if (depth == arr.length) {
            result = Math.max(result, num);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || (arr[i] == 0 && depth == 0) || num * 10 + arr[i] > B)
                continue;

            visited[i] = true;
            DFS(num * 10 + arr[i], depth + 1);
            visited[i] = false;
        }
    }
}
