package Silver4.Day97;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278 {
    public static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();

            if (input.contains("1")) {
                StringTokenizer st = new StringTokenizer(input);
                int command = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                processCommands(command, value);
            } else {
                int command = Integer.parseInt(input);

                int output = processCommands(command);
                sb.append(output).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void processCommands (int command, int value) {
        stack.push(value);
    }

    public static int processCommands (int command) {
        int output = Integer.MIN_VALUE;

        switch (command) {
            case 2:
                output = stack.isEmpty() ? -1 : stack.pop();
                break;
            case 3:
                output = stack.size();
                break;
            case 4:
                output = stack.isEmpty() ? 1 : 0;
                break;
            case 5:
                output = stack.isEmpty() ? -1 : stack.peek();
                break;
        }

        return output;
    }
}
