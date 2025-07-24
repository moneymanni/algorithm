package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11003 {

    private static int N, L;
    private static int[] A;
    private static Deque<Node> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int currVal = A[i];

            while (!deque.isEmpty() && deque.getLast().val > currVal) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, currVal));

            if (deque.getFirst().idx <= i - L) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().val).append(' ');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {

        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

    }

}
