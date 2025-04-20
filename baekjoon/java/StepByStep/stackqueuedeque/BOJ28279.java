package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28279 {

    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());

            if (op == 1 || op == 2) {
                int num = Integer.parseInt(st.nextToken());

                execute(op, num);
            } else {
                int num = execute(op);

                bw.write(num + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void execute(int op, int num) {
        switch (op) {
            case 1:
                deque.addFirst(num);
                break;
            case 2:
                deque.addLast(num);
                break;
        }
    }

    private static int execute(int op) {
        switch (op) {
            case 3:
                return !deque.isEmpty() ? deque.pollFirst() : -1;
            case 4:
                return !deque.isEmpty() ? deque.pollLast() : -1;
            case 5:
                return deque.size();
            case 6:
                return deque.isEmpty() ? 1 : 0;
            case 7:
                return !deque.isEmpty() ? deque.peekFirst() : -1;
            case 8:
                return !deque.isEmpty() ? deque.peekLast() : -1;
        }

        return -1;
    }
}
