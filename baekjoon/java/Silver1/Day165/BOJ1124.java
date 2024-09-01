package Silver1.Day165;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1124 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        findSieveOfEratosthenes(1_000);

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = A; i <= B; i++) {
            List<Integer> list = performPrimeFactorization(i);

            if (isPrime[list.size()]) cnt++;
        }

        bw.write(Integer.toString(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Integer> performPrimeFactorization(int num) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                list.add(i);
                num /= i;
            }
        }

        if(num != 1) {
            list.add(num);
        }

        return list;
    }

    private static void findSieveOfEratosthenes (int num) {
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
