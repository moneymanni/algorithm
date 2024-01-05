package Day59;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        String[] nums = br.readLine().split(",");
        for (int i = 0; i < nums.length; i++)
            A[i] = Integer.parseInt(nums[i]);

        int[] B = new int[N];
        int size = N - 1;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < size; j++)
                B[j] = A[j + 1] - A[j];
            A = Arrays.copyOf(B, B.length);
            size--;
        }

        if (K == 0)
            B =Arrays.copyOf(A, A.length);

        for (int i = 0; i < size + 1; i++) {
            if (i == size)
                bw.write(B[i] + "");
            else
                bw.write(B[i] + ",");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
