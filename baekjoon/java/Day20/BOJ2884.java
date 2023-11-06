package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = (H * 60 + M) - 45;
        if (result >= 0)
            System.out.printf("%d %d", result/60, result%60);
        else
            System.out.printf("%d %d", (24*60 + result)/60, (24*60 + result)%60);

        br.close();
    }
}
