package doit.day200;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        int result = queue.poll();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
