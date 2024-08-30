package Silver1.Day164;

import java.io.*;
import java.util.*;

public class BOJ15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ryanIdx = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int dollNum = Integer.parseInt(st.nextToken());

            if (dollNum == 1)
                ryanIdx.add(i);
        }

        int answer = Integer.MAX_VALUE;

        if (ryanIdx.size() >= K) {
            for (int i = 0; i <= ryanIdx.size() - K; i++) {
                int left = ryanIdx.get(i);
                int right = ryanIdx.get(i + K - 1);
                answer = Math.min(answer, right - left + 1);
            }
        } else {
            answer = -1;
        }

        bw.write(Integer.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
