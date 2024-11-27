package Silver4.Day89;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int insertPoint = i;
            int insertValue = A[i];

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0)
                    insertPoint = 0;
            }

            for (int j = i; j > insertPoint; j--)
                A[j] = A[j-1];

            A[insertPoint] = insertValue;
        }

        // 합 배열
        S[0] = A[0];
        for (int i = 1; i < N; i++)
            S[i] = S[i-1] + A[i];

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += S[i];

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
