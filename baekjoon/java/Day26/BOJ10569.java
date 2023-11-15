package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testCase[i][0] = Integer.parseInt(st.nextToken());
            testCase[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] polyhedron : testCase) {
            int V = polyhedron[0];
            int E = polyhedron[1];
            int result = 2 - V + E;
            System.out.println(result);
        }

        br.close();
    }
}
