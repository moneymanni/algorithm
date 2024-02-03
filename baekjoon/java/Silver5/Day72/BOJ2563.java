package Silver5.Day72;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2563 {
    public static boolean[][] whitePaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        whitePaper = new boolean[101][101];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++)
                for (int j = y; j < y + 10; j++)
                    whitePaper[i][j] = true;
        }

        int area = 0;
        for (int i = 1; i <= 100; i++)
            for (int j = 1; j <= 100; j++)
                if (whitePaper[i][j]) area++;

        bw.write(area + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
