package StepByStep.priorityqueue;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            int medianIdx = (M + 1) / 2;

            ArrayList<Integer> median = new ArrayList<>();
            int cnt = 0;

            bw.write(medianIdx + "\n");

            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                median.add(Integer.parseInt(st.nextToken()));
                Collections.sort(median);

                if (i % 2 == 0) {
                    if (cnt == 9 || i == M - 1) {
                        bw.write(median.get(i / 2) + "\n");
                        cnt = 0;
                    } else {
                        bw.write(median.get(i / 2) + " ");
                    }
                    cnt++;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
