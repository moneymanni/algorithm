package Silver4.Day102;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2567 {
    public static boolean[][] paper = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++)
                for (int j = y; j < y + 10; j++)
                    paper[i][j] = true;
        }

        int perimeter = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j]) {
                    if (i == 0 || !paper[i-1][j])
                        perimeter++;
                    if (i == 99 || !paper[i+1][j])
                        perimeter++;
                    if (j == 0 || !paper[i][j-1])
                        perimeter++;
                    if (j == 99 || !paper[i][j+1])
                        perimeter++;
                }

            }
        }

        bw.write(perimeter + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
