package Silver5.Day86;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0)
                break;

            int[] sanggeun = new int[N];
            for (int i = 0; i < N; i++)
                sanggeun[i] = Integer.parseInt(br.readLine());

            int[] seonyeong = new int[M];
            for (int i = 0; i < M; i++)
                seonyeong[i] = Integer.parseInt(br.readLine());

            int cnt = 0;
            int i = 0, j = 0;
            while (i < N && j < M) {
                if (sanggeun[i] > seonyeong[j]) {
                    j++;
                } else if (sanggeun[i] < seonyeong[j]) {
                    i++;
                } else {
                    cnt++;
                    i++;
                    j++;
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
