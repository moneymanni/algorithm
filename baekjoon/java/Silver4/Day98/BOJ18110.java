package Silver4.Day98;

import java.io.*;
import java.util.Arrays;

public class BOJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for (int i = 0; i < n; i++)
            levels[i] = Integer.parseInt(br.readLine());

        Arrays.sort(levels);

        int trimSize = (int) Math.round(levels.length * 0.15);
        int sum = 0;
        for (int i = trimSize; i < levels.length - trimSize; i++)
            sum += levels[i];

        double mean = (double) sum / (levels.length - 2 * trimSize);
        bw.write(Math.round(mean) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
