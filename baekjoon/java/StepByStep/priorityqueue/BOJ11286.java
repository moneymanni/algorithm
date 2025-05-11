package StepByStep.priorityqueue;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
        if (Math.abs(x) == Math.abs(y)) {
            return x - y;
        }

        return Math.abs(x) - Math.abs(y);
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                bw.write(pq.isEmpty() ? "0\n" : pq.poll() + "\n");
            } else {
                pq.add(x);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
