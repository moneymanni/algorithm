import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋다 : 백준 온라인 저지 1253번
 * https://www.acmicpc.net/problem/1253
 */

public class Num1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int cnt = 0;
        for (int k = 0; k < N; k++) {
            long find = A[k];
            int i = 0;
            int j = N-1;
            while (i < j) {
                if (A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        cnt++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(cnt);
        bf.close();
    }
}
