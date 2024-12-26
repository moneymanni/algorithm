package doit.day211;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            sum += num1 + num2;
            pq.add(num1 + num2);
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
