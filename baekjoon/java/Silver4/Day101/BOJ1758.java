package Silver4.Day101;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Integer[] tips = new Integer[N];
        for (int i = 0; i < N; i++)
            tips[i] = Integer.parseInt(br.readLine());

        Arrays.sort(tips, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int tip = tips[i] - i;

            if (tip > 0)
                sum += tip;
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
