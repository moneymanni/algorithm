package Silver4.Day90;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.offer(i);

        for (int i = 0; i < N - 1; i++) {
            queue.poll();
            Integer num = queue.poll();
            queue.offer(num);
        }
        bw.write(queue.poll() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
