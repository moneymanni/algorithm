package Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine().replace("D-", ""));

            if (num <= 90)
                cnt++;
        }
        System.out.println(cnt);

        br.close();
    }
}
