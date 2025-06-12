package StepByStep.dpandtraceback;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11780 {

    private static final int INF = 100_000_000;

    private static int n, m;
    private static int[][] cities;
    private static ArrayList<Integer>[][] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        cities = new int[n + 1][n + 1];
        trace = new ArrayList[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                trace[i][j] = new ArrayList<>();

                if (i != j) {
                    cities[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cities[a][b] = Math.min(cities[a][b], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cities[i][j] > cities[i][k] + cities[k][j]) {
                        cities[i][j] = cities[i][k] + cities[k][j];
                        trackingRoute(i, k, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cities[i][j] == INF) {
                    sb.append(0).append(' ');
                    continue;
                }

                sb.append(cities[i][j]).append(' ');
            }
            sb.append('\n');
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int size = trace[i][j].size();

                if (i == j || cities[i][j] == INF) {
                    sb.append(0).append('\n');
                    continue;
                }

                sb.append(size + 2).append(' ').append(i).append(' ');
                for (int city : trace[i][j]) {
                    sb.append(city).append(' ');
                }
                sb.append(j).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void trackingRoute(int start, int mid, int end) {
        trace[start][end].clear();

        for (int route : trace[start][mid]) {
            trace[start][end].add(route);
        }

        trace[start][end].add(mid);

        for (int route : trace[mid][end]) {
            trace[start][end].add(route);
        }
    }
}
