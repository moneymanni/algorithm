package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 사각형:     1개 -> 4개 -> 16개 -> 64개
        // 점의 개수:   4개 -> 9((루트4 + 1)^2)개 -> 25((루트16 + 1)^2)개
        // 공식 : (루트(4^N) + 1)^2

        int result = (int) Math.pow(Math.sqrt(Math.pow(4, N)) + 1, 2);
        System.out.println(result);

        br.close();
    }
}
