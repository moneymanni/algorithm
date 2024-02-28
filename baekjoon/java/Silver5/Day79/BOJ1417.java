package Silver5.Day79;

import java.io.*;
import java.util.stream.IntStream;

public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] candidates = new int[N];
        for (int i = 0; i < N; i++)
            candidates[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            int maxIdx = IntStream.range(0, candidates.length)
                    .reduce((i, j) -> candidates[i] > candidates[j] ? i : j)
                    .getAsInt();

            if (maxIdx == 0)
                break;

            candidates[maxIdx]--;
            candidates[0]++;
            cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
