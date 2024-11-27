package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][][] testCase = new int[T][9][2];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                testCase[i][j][0] = Integer.parseInt(st.nextToken());
                testCase[i][j][1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            int yonsei = 0;
            int korea = 0;
            for (int j = 0; j < 9; j++) {
                yonsei += testCase[i][j][0];
                korea += testCase[i][j][1];
            }
            if (yonsei > korea)
                sb.append("Yonsei").append("\n");
            else if (yonsei < korea)
                sb.append("Korea").append("\n");
            else
                sb.append("Draw").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
