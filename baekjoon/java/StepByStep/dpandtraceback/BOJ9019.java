package StepByStep.dpandtraceback;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {

    private static final String DOUBLE = "D";
    private static final String SUBTRACT_ONE = "S";
    private static final String ROTATE_LEFT = "L";
    private static final String ROTATE_RIGHT = "R";
    private static final int MAX_VALUE = 10_000;

    private static int T, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bw.write(BFS(A, B) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String BFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_VALUE + 1];
        String[] commands = new String[MAX_VALUE + 1];

        Arrays.fill(commands, "");

        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty() && !visited[b]) {
            int curr = queue.poll();

            int D = (curr * 2) % MAX_VALUE;
            int S = (curr - 1 + MAX_VALUE) % MAX_VALUE;
            int L = (curr % 1_000) * 10 + curr / 1_000;
            int R = (curr % 10) * 1_000 + curr / 10;

            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                commands[D] = commands[curr] + DOUBLE;
            }
            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                commands[S] = commands[curr] + SUBTRACT_ONE;
            }
            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                commands[L] = commands[curr] + ROTATE_LEFT;
            }
            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                commands[R] = commands[curr] + ROTATE_RIGHT;
            }
        }

        return commands[b];
    }
}
