package Silver4.Day94;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        int cnt = 0, result = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (!isPrime[j])
                        continue;
                    isPrime[j] = false;

                    if (++cnt == K) {
                        result = j;
                        break;
                    }
                }
            }
            if (result != 0)
                break;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
