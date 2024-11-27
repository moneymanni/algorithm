package Silver4.Day92;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {
    public static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();

        while (N-- > 0) {
            String line = br.readLine();

            String command = "";
            if (line.contains("push")) {
                StringTokenizer st = new StringTokenizer(line);
                command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                processCommands(command, num);
            } else {
                command = line;

                int output = processCommands(command);
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
                queue.offer(num);
                break;
        }
    }

    public static int processCommands (String command) {
        int output;

        switch (command) {
            case "pop":
                output = queue.isEmpty() ? -1 : queue.poll();
                break;
            case "size":
                output = queue.size();
                break;
            case "empty":
                output = queue.isEmpty() ? 1 : 0;
                break;
            case "front":
                output = queue.isEmpty() ? -1 : queue.peekFirst();
                break;
            case "back":
                output = queue.isEmpty() ? -1 : queue.peekLast();
                break;
            default:
                output = 404;
        }

        return output;
    }
}
