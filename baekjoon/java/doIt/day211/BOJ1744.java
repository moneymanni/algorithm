package doit.day211;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(br.readLine());

            if (num > 0) plusPq.add(num);
            else minusPq.add(num);
        }

        int sum = 0;

        while (minusPq.size() >= 2) {
            sum += minusPq.poll() * minusPq.poll();
        }
        sum = minusPq.isEmpty() ? sum : sum + minusPq.poll();

        while (plusPq.size() >= 2) {
            int num1 = plusPq.poll();
            int num2 = plusPq.poll();

            sum += Math.max(num1 * num2, num1 + num2);
        }
        sum = plusPq.isEmpty() ? sum : sum + plusPq.poll();

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
