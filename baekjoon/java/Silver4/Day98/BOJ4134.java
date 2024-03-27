package Silver4.Day98;

import java.io.*;

public class BOJ4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());

            while (!isPrime(n))
                n++;
            bw.write(n + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isPrime (long n) {
        if (n <= 1)
            return false;

        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
