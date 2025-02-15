package doIt.day234;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11403 {

    private static int G;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        G = Integer.parseInt(br.readLine());

        dist = new int[G + 1][G + 1];

        for (int i = 1; i <= G; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= G; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();

        for (int i = 1; i <= G; i++) {
            for (int j = 1; j <= G; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= G; k++) {
            for (int i = 1; i <= G; i++) {
                for (int j = 1; j <= G; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
    }
}
