package Silver5.Day85;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            bw.write("0");
        } else {
            st = new StringTokenizer(br.readLine());
            int[] books = new int[N];
            for (int i = 0 ; i < N; i++)
                books[i] = Integer.parseInt(st.nextToken());

            int cnt = 1;
            int currBook = 0;
            for (int i = 0; i < N; i++) {
                if (currBook + books[i] <= M) {
                    currBook += books[i];
                } else {
                    cnt++;
                    currBook = books[i];
                }
            }

            bw.write(cnt + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
