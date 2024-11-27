package Gold4.Day194;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(BFS(a, b) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String BFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10_000];
        String[] commands = new String[10_000];

        Arrays.fill(commands, "");

        queue.offer(a);
        visited[a] = true;

        while (!queue.isEmpty() && !visited[b]) {
            int curr = queue.poll();

            int D = (2 * curr) % 10_000;
            int S = (curr == 0) ? 9_999 : curr - 1;
            int L = (curr % 1_000) * 10 + curr / 1_000;
            int R = (curr % 10) * 1_000 + curr / 10;

            if (!visited[D]) {
                queue.offer(D);
                visited[D] = true;
                commands[D] = commands[curr] + "D";
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                commands[S] = commands[curr] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                commands[L] = commands[curr] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                commands[R] = commands[curr] + "R";
            }
        }

        return commands[b];
    }
}
