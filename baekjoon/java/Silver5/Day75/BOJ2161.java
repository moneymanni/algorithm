package Silver5.Day75;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.offer(i);

        int card = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (queue.size() == 1)
                break;
            sb.append(queue.poll()).append(" ");
            queue.offer(queue.poll());
        }
        sb.append(queue.poll());
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
