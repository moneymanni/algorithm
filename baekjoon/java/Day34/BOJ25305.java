package Day34;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < score.length; i++)
            score[i] = Integer.parseInt(st.nextToken());

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int point = i;
            int value = score[i];

            for (int j = i - 1; j >= 0; j--) {
                if (score[j] > score[i]) {
                    point = j + 1;
                    break;
                }
                if (j == 0)
                    point = 0;
            }
            for (int j = i; j > point; j--)
                score[j] = score[j-1];
            score[point] = value;
        }

        bw.write(score[k-1] + "");

        br.close();
        bw.close();
    }
}
