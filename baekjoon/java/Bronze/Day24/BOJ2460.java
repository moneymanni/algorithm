package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 내리고 탄다
        int train = 0;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            train -= Integer.parseInt(st.nextToken());
            train += Integer.parseInt(st.nextToken());
            max = Math.max(max, train);
        }
        System.out.println(max);

        br.close();
    }
}
