package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] school = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            school[i][0] = Integer.parseInt(st.nextToken());
            school[i][1] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += school[i][1] % school[i][0];
        System.out.println(sum);

        br.close();
    }
}
