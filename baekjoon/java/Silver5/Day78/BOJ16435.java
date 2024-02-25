package Silver5.Day78;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++)
            fruits[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(fruits);

        int snakebird = L;
        for (int fruit : fruits) {
            if (snakebird >= fruit)
                snakebird++;
            else
                break;
        }
        bw.write(snakebird + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
