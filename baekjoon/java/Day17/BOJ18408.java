package Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 1이 많으면 A + B + C는 3 또는 4가 나오고, 2가 많다면 A + B + C는 5 또는 6이 나온다.
        if (A + B + C <= 4)
            System.out.println(1);
        else
            System.out.println(2);

        br.close();
    }
}
