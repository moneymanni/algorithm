package doIt.day250;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        int[] stone = new int[M];
        double[] result = new double[M];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
            total += stone[i];
        }

        int K = Integer.parseInt(br.readLine());

        double answer = 0;

        for (int i = 0; i < M; i++) {
            result[i] = 1.0;

            for (int j = 0; j < K; j++) {
                result[i] *= (double) (stone[i] - j) / (total - j);
            }
            answer += result[i];
        }

//        bw.write(String.format("%f\n", answer));
        System.out.println(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
