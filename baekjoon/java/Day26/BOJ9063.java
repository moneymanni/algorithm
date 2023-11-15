package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxX = -10_000;
        int maxY = -10_000;
        int minX = 10_000;
        int minY = 10_000;
        for (int i = 0; i < N; i++) {
            maxX = Math.max(maxX, coordinates[i][0]);
            maxY = Math.max(maxY, coordinates[i][1]);
            minX = Math.min(minX, coordinates[i][0]);
            minY = Math.min(minY, coordinates[i][1]);
        }
        int result = (maxX - minX) * (maxY - minY);
        System.out.println(result);

        br.close();
    }
}
