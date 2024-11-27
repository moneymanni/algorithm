package Silver4.Day90;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static int N, M;
    public static int[] A, search;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        search = new int[M];
        for (int i = 0; i < M; i++)
            search[i] = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < M; i++) {
            if (binary(search[i]))
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean binary (int target) {
        int start = 0, end  = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] == target)
                return true;

            if (target < A[mid])
                end = mid - 1;
            else if (target > A[mid])
                start = mid + 1;
        }

        return false;
    }
}
