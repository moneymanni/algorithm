package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] cup = new int[]{1, 0, 0};

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int temp = cup[A-1];
            cup[A-1] = cup[B-1];
            cup[B-1] = temp;
        }
        for (int i = 0; i < cup.length; i++)
            if (cup[i] == 1)
                System.out.println(i+1);

        br.close();
    }
}
