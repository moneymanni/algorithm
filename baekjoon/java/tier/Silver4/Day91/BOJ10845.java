package Silver4.Day91;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();

        while (N-- > 0) {
            String line = br.readLine();

            String command;
            int output;
            if (line.contains("push")) {
                StringTokenizer st = new StringTokenizer(line);
                command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                processCommands(command, num);
            } else {
                command = line;
                output = processCommands(command);
                bw.write(output + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void processCommands (String command, int num) {
        switch (command) {
            case "push":
                deque.offer(num);
                break;
        }
    }

    public static int processCommands (String command) {
        int output = 404;

        switch (command) {
            case "pop":
                output = deque.isEmpty() ? -1 : deque.poll();
                break;
            case "size":
                output = deque.size();
                break;
            case "empty":
                output = deque.isEmpty() ? 1 : 0;
                break;
            case "front":
                output = deque.isEmpty() ? -1 : deque.peekFirst();
                break;
            case "back":
                output = deque.isEmpty() ? -1 : deque.peekLast();
                break;
        }

        return output;
    }
}
