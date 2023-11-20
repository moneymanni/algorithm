package Day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int num = 0;
        for (int milk : A) {
            switch (milk) {
                case 0:
                    if (num == 0) {
                        cnt++;
                        num++;
                    }
                    break;
                case 1:
                    if (num == 1) {
                        cnt++;
                        num++;
                    }
                    break;
                case 2:
                    if (num == 2) {
                        cnt++;
                        num = 0;
                    }
                    break;
            }
        }
        System.out.println(cnt);

        br.close();
    }
}
