package Day33;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 시험장의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());  // 총감독관이 감시할 수 있는 응시자 수
        int C = Integer.parseInt(st.nextToken());  // 부감독관이 감시할 수 있는 응시자 수

        long total = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] <= B) {
                total++;
            } else {
                total++;
                A[i] -= B;

                if (A[i] % C == 0)
                    total += A[i] / C;
                else
                    total += A[i] / C + 1;
            }
        }
        bw.write(total + "\n");

        br.close();
        bw.close();
    }
}
