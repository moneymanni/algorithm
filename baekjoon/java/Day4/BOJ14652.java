package Day4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14652 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            long idx = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (idx == K) {
                        String result = i + " " + j;
                        bw.write(result);
                    }
                    idx++;
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
