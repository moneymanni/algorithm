package Day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] available = new int[3];
        int[] requested = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            available[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            requested[i] = Integer.parseInt(st.nextToken());

        int num = 0;
        for (int i = 0; i < 3; i++)
            num += available[i] < requested[i] ? requested[i] - available[i] : 0;
        System.out.println(num);

        br.close();
    }
}
