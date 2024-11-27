package Silver1.Day151;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {
    private static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) != Math.abs(b))
                return Math.abs(a) - Math.abs(b);
            else
                return a - b;
        });

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(queue.poll() + "\n");
            } else {
                queue.add(num);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
