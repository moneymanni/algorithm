package Gold5.Day176;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2023 {
    private static int N;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        DFS(0, 0);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int num : list) sb.append(num).append('\n');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int prevNum, int depth) {
        if (depth == N) {
            if (isPrime(prevNum))
                list.add(prevNum);

            return;
        }

        for (int i = 1; i <= 9; i++) {
            int currNum = prevNum * 10 + i;

            if (isPrime(currNum)) {
                DFS(currNum, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
