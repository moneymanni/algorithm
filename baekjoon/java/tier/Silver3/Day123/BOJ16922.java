package Silver3.Day123;

import java.io.*;
import java.util.HashSet;

public class BOJ16922 {
    static final int[] ROMAN_NUM = {1, 5, 10, 50};
    static int N, cnt;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        cnt = 0;
        check = new boolean[1001];

        DFS(0, 0, 0);
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int v, int depth, int num) {
        if (depth == N) {
            if (!check[num]) {
                check[num] = true;
                cnt++;
            }
            return;
        }

        for (int i = v; i < ROMAN_NUM.length; i++)
            DFS(i, depth + 1, num + ROMAN_NUM[i]);
    }
}

//public class BOJ16922 {
//    static final int[] ROMAN_NUM = {1, 5, 10, 50};
//
//    static int N;
//    static HashSet<Integer> sum;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        N = Integer.parseInt(br.readLine());
//
//        sum = new HashSet<>();
//
//        DFS(0, 0, 0);
//
//        bw.write(sum.size() + "");
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//
//    static void DFS(int v, int depth, int currSum) {
//        if (depth == N) {
//            sum.add(currSum);
//            return;
//        }
//
//        for (int i = v; i < ROMAN_NUM.length; i++) {
//            DFS(i, depth + 1, currSum + ROMAN_NUM[i]);
//        }
//    }
//}