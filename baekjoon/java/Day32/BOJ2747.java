package Day32;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> fibonacciNums = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                fibonacciNums.add(0);
                continue;
            } else if (i == 1) {
                fibonacciNums.add(1);
                continue;
            }
            fibonacciNums.add(fibonacciNums.get(i-1) + fibonacciNums.get(i-2));
        }
        bw.write(fibonacciNums.get(N) + "");

        br.close();
        bw.close();
    }
}
