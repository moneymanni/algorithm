package StepByStep.dpandtraceback;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {

    private static final int INF = Integer.MAX_VALUE;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100_000;

    private static int N, K;
    private static Node[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solution(N, K);

        bw.write(dp[K].cnt + "\n");

        Stack<Integer> stack = new Stack<>();

        stack.push(K);

        while (dp[stack.peek()].prevIdx != -1) {
            stack.push(dp[stack.peek()].prevIdx);
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    private static void solution(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        dp = new Node[MAX_VALUE + 1];

        for (int i = 0; i <= MAX_VALUE; i++) {
            dp[i] = new Node(INF, -1);
        }

        queue.add(start);
        dp[start] = new Node(0, -1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == end) {
                return;
            }

            if (curr + 1 <= MAX_VALUE && dp[curr + 1].cnt > dp[curr].cnt + 1) {
                dp[curr + 1] = new Node(dp[curr].cnt + 1, curr);
                queue.add(curr + 1);
            }
            if (curr - 1 >= MIN_VALUE && dp[curr - 1].cnt > dp[curr].cnt + 1) {
                dp[curr - 1] = new Node(dp[curr].cnt + 1, curr);
                queue.add(curr - 1);
            }
            if (curr * 2 <= MAX_VALUE && dp[curr * 2].cnt > dp[curr].cnt + 1) {
                dp[curr * 2] = new Node(dp[curr].cnt + 1, curr);
                queue.add(curr * 2);
            }
        }
    }

    private static class Node {
        int cnt;
        int prevIdx;

        public Node(int cnt, int prevIdx) {
            this.cnt = cnt;
            this.prevIdx = prevIdx;
        }
    }
}
