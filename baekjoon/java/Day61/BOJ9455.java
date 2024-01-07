package Day61;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] box = new int[m][n];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++)
                    box[j][k] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < m; x++) {
                    if (box[x][j] == 0) continue;

                    int numOfSpacesMoved = 0;
                    for (int y = x + 1; y < m; y++) {
                        if (box[y][j] == 0)
                            numOfSpacesMoved++;
                    }
                    result += numOfSpacesMoved;
                }
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
