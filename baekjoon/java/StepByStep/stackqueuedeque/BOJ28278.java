package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int num = Integer.parseInt(st.nextToken());

                execute(op, num);
            } else {
                int num = execute(op);

                bw.write(num +"\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void execute(int op, int num) {
        switch (op) {
            case 1:
                stack.push(num);
                break;
        }
    }

    private static int execute(int op) {
        switch (op) {
            case 2:
                return !stack.isEmpty() ? stack.pop() : -1;
            case 3:
                return stack.size();
            case 4:
                return stack.isEmpty() ? 1 : 0;
            case 5:
                return !stack.isEmpty() ? stack.peek() : -1;
        }

        return -1;
    }
}
