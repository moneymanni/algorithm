package Day57;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int idx = 0, num = N;
        int[] A = new int[P + 1];
        boolean isFound = false;
        while (!isFound) {
            num = num * N % P;
            for (int i = 0; i < idx; i++) {
                if (A[i] == num) {
                    isFound = true;
                    bw.write(String.valueOf(idx - i));
                    break;
                }
            }
            A[idx] = num;
            idx++;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}