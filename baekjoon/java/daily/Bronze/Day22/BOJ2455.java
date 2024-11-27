package Day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalNum = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stopover = Integer.parseInt(st.nextToken());
            int riding = Integer.parseInt(st.nextToken());
            totalNum += riding;
            totalNum -= stopover;
            max = Math.max(max, totalNum);
        }
        System.out.println(max);

        br.close();
    }
}
