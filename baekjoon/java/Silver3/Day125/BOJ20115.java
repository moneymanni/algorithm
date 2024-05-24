package Silver3.Day125;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        double[] drink = new double[N];
        double max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            drink[i] = Double.parseDouble(st.nextToken());
            max = Math.max(max, drink[i]);
        }

        double mixedDrink = max;
        for (int i = 0; i < N; i++) {
            if (drink[i] == max)
                continue;

            mixedDrink += drink[i] / 2;
        }

        bw.write(String.valueOf(mixedDrink));

        br.close();
        bw.flush();
        bw.close();
    }
}
