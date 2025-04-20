package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.*;

public class BOJ11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }

            list.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder("<");

        for (int i = 0; i < N - 1; i++) {
            sb.append(list.get(i)).append(", ");
        }
        sb.append(list.get(N - 1)).append(">\n");

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
