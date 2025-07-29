package StepByStep.stackqueuedeque2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ33918 {

    private static final long INF = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] b = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        long[] dpPrev = new long[M + 1];
        for (int k = 1; k <= M; k++) {
            dpPrev[k] = (long) M - Math.abs(b[0] - k);
        }

        long[] dpCurr = new long[M + 1];
        int W = D / C;

        for (int t = 1; t < N; t++) {
            Arrays.fill(dpCurr, INF);

            for (int r = 0; r < C; r++) {
                int startTemp = (r == 0) ? C : r;
                if (startTemp > M) continue;

                List<Long> vals = new ArrayList<>();
                List<Integer> temps = new ArrayList<>();
                for (int k = startTemp; k <= M; k += C) {
                    vals.add(dpPrev[k]);
                    temps.add(k);
                }

                if (vals.isEmpty()) continue;

                int numVals = vals.size();
                long[] L = new long[numVals];
                long[] R = new long[numVals];
                Deque<Integer> dq = new ArrayDeque<>();

                for (int j = 0; j < numVals; j++) {
                    if (!dq.isEmpty() && dq.peekFirst() < j - W) {
                        dq.pollFirst();
                    }
                    while (!dq.isEmpty() && vals.get(dq.peekLast()) <= vals.get(j)) {
                        dq.pollLast();
                    }
                    dq.addLast(j);
                    L[j] = vals.get(dq.peekFirst());
                }

                dq.clear();

                for (int j = numVals - 1; j >= 0; j--) {
                    if (!dq.isEmpty() && dq.peekFirst() > j + W) {
                        dq.pollFirst();
                    }
                    while (!dq.isEmpty() && vals.get(dq.peekLast()) <= vals.get(j)) {
                        dq.pollLast();
                    }
                    dq.addLast(j);
                    R[j] = vals.get(dq.peekFirst());
                }

                for (int j = 0; j < numVals; j++) {
                    long maxPrev = Math.max(L[j], R[j]);
                    if (maxPrev > INF + 1) {
                        int currentTemp = temps.get(j);
                        long gain = (long) M - Math.abs(b[t] - currentTemp);
                        dpCurr[currentTemp] = Math.max(dpCurr[currentTemp], gain + maxPrev);
                    }
                }
            }

            long[] temp = dpPrev;
            dpPrev = dpCurr;
            dpCurr = temp;
        }

        long maxTotalTaste = 0;
        for (int k = 1; k <= M; k++) {
            maxTotalTaste = Math.max(maxTotalTaste, dpPrev[k]);
        }

        System.out.println(maxTotalTaste);
    }

}
