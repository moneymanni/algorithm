package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ15678 {

    private static int N, D;
    private static long[] K;
    private static Node[] nodes;
    private static Deque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        nodes = new Node[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            nodes[i] = new Node(i, Long.parseLong(st.nextToken()));
        }

        long result = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peekLast().idx + D < i) {
                deque.pollLast();
            }

            if (deque.isEmpty()) {
                deque.offer(nodes[i]);
                continue;
            }

            if (deque.peekLast().val <= deque.peekLast().val + nodes[i].val) {
                deque.addLast(new Node(i, deque.peekLast().val + nodes[i].val));
            } else {
                while (deque.size() > 1 && deque.peekFirst().val <= deque.peekLast().val + nodes[i].val) {
                    deque.pollFirst();
                }
                deque.addFirst(new Node(i, deque.peekLast().val + nodes[i].val));
            }

            if (deque.peekLast().val <= nodes[i].val) {
                deque.addLast(new Node(i, nodes[i].val));
            }
            result = Math.max(result, deque.peekLast().val);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {

        int idx;
        long val;

        public Node(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }
    }

}
