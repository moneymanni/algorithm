package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] like = new int[3];
        for (int i = 0; i < 3; i++)
            like[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < 3; i++) {
            int d = N - like[i];
            if (d <= 0)
                result += N;
            else
                result += like[i];
        }
        System.out.println(result);

        br.close();
    }
}
