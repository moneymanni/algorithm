package doIt.day206;

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

        for (int i : list) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int num, int depth) {
        if (depth == N) {
            if (isPrime(num)) {
                list.add(num);
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            int nextNum = num * 10 + i;

            if (isPrime(nextNum)) {
                DFS(nextNum, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
