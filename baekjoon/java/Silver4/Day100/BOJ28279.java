package Silver4.Day100;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28279 {
    public static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();

            if (input.contains("1") || input.contains("2")) {
                StringTokenizer st = new StringTokenizer(input);
                int command = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                processCommand(command, num);
            } else {
                int command = Integer.parseInt(input);

                int output = processCommand(command);

                sb.append(output).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void processCommand (int command, int num) {
        switch (command) {
            case 1:
                deque.offerFirst(num);
                break;
            case 2:
                deque.offerLast(num);
                break;
        }
    }

    public static int processCommand (int command) {
        int output = 404;

        switch (command) {
            case 3:
                output = deque.isEmpty() ? -1 : deque.pollFirst();
                break;
            case 4:
                output = deque.isEmpty() ? -1 : deque.pollLast();
                break;
            case 5:
                output = deque.size();
                break;
            case 6:
                output = deque.isEmpty() ? 1 : 0;
                break;
            case 7:
                output = deque.isEmpty() ? -1 : deque.peekFirst();
                break;
            case 8:
                output = deque.isEmpty() ? -1 : deque.peekLast();
                break;
        }

        return output;
    }
}
