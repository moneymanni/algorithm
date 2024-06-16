package Silver2.Day143;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6236 {
    private static int N, M;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        int start = 0;
        int end = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, A[i]);
            end += A[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (M >= getCnt(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getCnt(int amount) {
        int cnt = 1;
        int money = amount;

        for (int i : A) {
            money -= i;

            if (money < 0) {
                ++cnt;
                money = amount - i;
            }
        }

        return cnt;
    }
}
