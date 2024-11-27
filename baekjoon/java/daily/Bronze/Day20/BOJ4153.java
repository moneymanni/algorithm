package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] triangle = new int[3];
        for (int i = 0; i < 3; i++)
            triangle[i] = Integer.parseInt(st.nextToken());

        while (triangle[0] != 0 || triangle[1] != 0 || triangle[2] != 0) {
            Arrays.sort(triangle);
            if (triangle[2]*triangle[2] == triangle[0]*triangle[0] + triangle[1]*triangle[1])
                sb.append("right\n");
            else
                sb.append("wrong\n");

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++)
                triangle[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);

        br.close();
    }
}
