package Silver4.Day101;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] purchase = new Integer[N];
        for (int i = 0; i < N; i++)
            purchase[i] = Integer.parseInt(br.readLine());

        Arrays.sort(purchase, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 != 0)
                sum += purchase[i];
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
