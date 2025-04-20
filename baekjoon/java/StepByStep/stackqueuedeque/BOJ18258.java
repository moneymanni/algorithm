package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18258 {

    private static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            if (op.equals("push")) {
                int num = Integer.parseInt(st.nextToken());

                execute(op, num);
            } else {
                int output = execute(op);

                bw.write(output + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void execute(String op, int num) {
        switch (op) {
            case "push":
                queue.add(num);
                break;
        }
    }

    private static int execute(String op) {
        switch (op) {
            case "pop":
                return !queue.isEmpty() ? queue.poll() : -1;
            case "size":
                return queue.size();
            case "empty":
                return queue.isEmpty() ? 1 : 0;
            case "front":
                return !queue.isEmpty() ? queue.peekFirst() : -1;
            case "back":
                return !queue.isEmpty() ? queue.peekLast() : -1;
        }

        return -1;
    }
}
