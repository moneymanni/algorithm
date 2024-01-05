package Day59;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10163 {
    public static final int PAPER_SIZE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] paper = new boolean[PAPER_SIZE][PAPER_SIZE];

        int N = Integer.parseInt(br.readLine());
        int[][] testCase = new int[N][4];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = testCase.length - 1; i >= 0; i--) {
            int x = testCase[i][0];
            int y = testCase[i][1];
            int width = testCase[i][2];
            int height = testCase[i][3];

            int sum = 0;
            for (int j = x; j < x + width; j++) {
                for (int k = y; k < y + height; k++) {
                    if (paper[j][k])
                        continue;
                    paper[j][k] = true;
                    sum++;
                }
            }

            list.add(sum);
        }

        Collections.reverse(list);

        for (Integer i : list) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
