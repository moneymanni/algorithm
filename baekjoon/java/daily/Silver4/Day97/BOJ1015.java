package Silver4.Day97;

import java.io.*;
import java.util.*;

public class BOJ1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }

        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    sb.append(j).append(' ');
                    B[j] = -1;
                    break;
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
