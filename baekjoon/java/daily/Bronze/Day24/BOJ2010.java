package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] multitab = new int[N];
        for (int i = 0; i < N; i++)
            multitab[i] = Integer.parseInt(br.readLine());

        // 총 플러그 개수 - N
        int sum = Arrays.stream(multitab).sum() + 1;
        System.out.println(sum - N);

        br.close();
    }
}
