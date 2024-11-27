package Silver4.Day108;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];  // '\u0000'
        Arrays.fill(wheel, '?');

        int idx = 0;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int change = Integer.parseInt(st.nextToken());
            char current = st.nextToken().charAt(0);

            idx -= change % N;
            if (idx < 0)
                idx += N;

            if (wheel[idx] != '?' && wheel[idx] != current) {
                bw.write("!");
                bw.flush();
                return;
            }

            wheel[idx] = current;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (wheel[i] != '?' && wheel[i] == wheel[j]) {
                    bw.write("!");
                    bw.flush();
                    return;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++)
            result.append(wheel[(idx + i) % N]);

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
