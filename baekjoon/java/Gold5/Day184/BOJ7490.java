package Gold5.Day184;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ7490 {
    private static final char[] OP = {'+', '-', ' '};
    private static int N;
    private static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();

            DFS(1, "1");

            Collections.sort(list);

            for (String str : list)
                bw.write(str + "\n");
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int num, String str) {
        if (num == N) {
            String express = str.replaceAll(" ", "");
            if (calculate(express) == 0)
                list.add(str);
            return;
        }

        for (char ch : OP)
            DFS(num + 1, str + ch + (num + 1));
    }

    private static int calculate(String express) {
        StringTokenizer st = new StringTokenizer(express, "-|+", true);

        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            if (str.equals("+"))
                sum += Integer.parseInt(st.nextToken());
            else
                sum -= Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
