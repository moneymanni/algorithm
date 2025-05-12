package StepByStep.priorityqueue;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {

    private static int N, K;
    private static int[] bags;
    private static Jewel[] jewels;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bags = new int[K];
        jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(M, V);
        }

        Arrays.sort(jewels);

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        long answer = 0L;

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewels[j].mass <= bags[i]) {
                pq.add(jewels[j++].value);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Jewel implements Comparable<Jewel> {
        int mass;
        int value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel obj) {
            if (this.mass == obj.mass) {
                return obj.value - this.value;
            }

            return this.mass - obj.mass;
        }
    }
}
