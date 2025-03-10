package doIt.day251;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1722 {

    private static int N, Q;
    private static int[] S = new int[21];
    private static long[] F = new long[21];
    private static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());

        F[0] = 1L;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {
            long k = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) continue;

                    if (k <= cnt * F[N - i]) {
                        k -= ((cnt - 1) * F[N - i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                bw.write(S[i] + " ");
            }
            bw.newLine();
        } else if (Q == 2) {
            long k = 1;

            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;

                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                k += cnt * F[N - i];
                visited[S[i]] = true;
            }
            bw.write(k + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
