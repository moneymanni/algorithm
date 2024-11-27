package Silver3.Day109;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1929 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        sieveOfEratosthenes(N);

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i])
                sb.append(i).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void sieveOfEratosthenes(int end) {
        isPrime = new boolean[end+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
