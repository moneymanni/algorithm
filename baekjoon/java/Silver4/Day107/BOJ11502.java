package Silver4.Day107;

import java.io.*;
import java.util.Arrays;

public class BOJ11502 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            sieveOfEratosthenes(K);

            StringBuilder sb = new StringBuilder();
            boolean foundThreeNum = false;
            first: for (int i = 2; i <= K; i++) {
                second: for (int j = 2; j <= K; j++) {
                    for (int l = 2; l <= K; l++) {
                        if (i + j > K)
                            break second;
                        else if (i + j + l > K)
                            break;

                        if (i + j + l == K && isPrime[i] && isPrime[j] && isPrime[l]) {
                            sb.append(i).append(' ');
                            sb.append(j).append(' ');
                            sb.append(l).append(' ');
                            sb.append('\n');
                            foundThreeNum = true;
                            break first;
                        }
                    }
                }
            }

            if (foundThreeNum)
                bw.write(sb.toString());
            else
                bw.write("0");
        }

        br.close();
        bw.flush();
        bw.close();
    }

//    static boolean isPrime(int num) {
//        for (int i = 2; i <= Math.sqrt(num); i++)
//            if (num % i == 0)
//                return false;
//        return true;
//    }

    static void sieveOfEratosthenes(int num) {
        isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
