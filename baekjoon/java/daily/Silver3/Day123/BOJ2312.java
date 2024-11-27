package Silver3.Day123;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BOJ2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            List<Integer> primeList = primeFactorization(N);

            TreeMap<Integer, Integer> primeMap = new TreeMap<>();
            for(int i = 0; i < primeList.size(); i++)
                primeMap.put(primeList.get(i), primeMap.getOrDefault(primeList.get(i), 0) + 1);

            for (Map.Entry<Integer, Integer> entry : primeMap.entrySet()) {
                int factor = entry.getKey();
                int cnt = entry.getValue();

                sb.append(factor).append(' ').append(cnt).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    static List<Integer> primeFactorization(int N) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                list.add(i);
                N /= i;
            }
        }

        if (N != 1)
            list.add(N);

        return list;
    }
}
