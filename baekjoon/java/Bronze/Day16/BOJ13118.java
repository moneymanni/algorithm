package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[4];
        for (int i = 0; i < 4; i++)
            p[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] apple = new int[3];
        for (int i = 0; i < 3; i++)
            apple[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < 4; i++)
            if (apple[0] == p[i])
                result += i + 1;
        System.out.println(result);

        br.close();
    }
}
