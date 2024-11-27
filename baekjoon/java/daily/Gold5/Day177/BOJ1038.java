package Gold5.Day177;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1038 {
    private static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            bw.write(N + "");
        } else if (N > 1022) {
            bw.write("-1");
        } else {
            list = new ArrayList<>();

            for (int i = 0; i < 10; i++)
                DFS(i, 1);

            Collections.sort(list);

            bw.write(list.get(N) + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(long num, int depth) {
        if (depth > 10)
            return;

        list.add(num);

        for (int i = 0; i < num % 10; i++)
            DFS((num * 10) + i, depth + 1);
    }
}
