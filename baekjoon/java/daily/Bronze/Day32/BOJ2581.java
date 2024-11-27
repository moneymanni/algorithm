package Day32;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체
        List<Integer> primeNums = sieveOfEratosthenes(M, N);
        Collections.sort(primeNums);

        if (primeNums.isEmpty()) {
            bw.write("-1");
        } else {
            int sum = primeNums.stream().mapToInt(Integer::intValue).sum();
            bw.write(String.format("%d\n%d", sum, primeNums.get(0)));
        }

        br.close();
        bw.close();
    }

    public static List<Integer> sieveOfEratosthenes (int M, int N) {
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * 2; j <= N; j += i)
                isPrime[j] = false;
        }

        List<Integer> primeNums = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            if (isPrime[i])
                primeNums.add(i);
        }

        return primeNums;
    }
}
