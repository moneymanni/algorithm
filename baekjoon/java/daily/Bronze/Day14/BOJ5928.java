package Day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int standard = ((11 * 24) + 11) * 60 + 11;
        int result = ((D * 24) + H) * 60 + M;
        if (standard > result)
            System.out.println(-1);
        else
            System.out.println(result - standard);
        br.close();
    }
}
