package StepByStep.setandmap;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int cnt = 0;

        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
