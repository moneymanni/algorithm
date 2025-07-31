package StepByStep.geometry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2166 {

    private static int N;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (double) nodes[i].x * nodes[(i + 1) % N].y;
            sum -= (double) nodes[i].y * nodes[(i + 1) % N].x;
        }

        bw.write(String.format("%.1f\n", Math.abs(sum / 2)));

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
