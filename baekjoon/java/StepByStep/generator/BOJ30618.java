package StepByStep.generator;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ30618 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        boolean flag = false;

        for (int i = N; i >= 1; i--) {
            if (!flag) {
                deque.addLast(i);
            } else {
                deque.addFirst(i);
            }

            flag = !flag;
        }

        while (!deque.isEmpty()) {
            bw.write(deque.poll() + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
