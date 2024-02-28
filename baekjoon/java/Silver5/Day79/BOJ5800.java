package Silver5.Day79;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int idx = 1;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] grades = new int[N];
            for (int i = 0; i < N; i++)
                grades[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(grades);

            int max = grades[N-1], min = grades[0];
            int gap = IntStream.range(0, N - 1)
                    .map(i -> grades[i+1] - grades[i])
                    .max()
                    .getAsInt();

            bw.write(String.format("Class %d\nMax %d, Min %d, Largest gap %d\n", idx++, max, min, gap));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
