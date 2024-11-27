package Silver5.Day69;

import java.io.*;

public class BOJ2751 {
    public static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(br.readLine());

        mergetSort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void mergetSort (int start, int end) {
        if (end - start < 1)
            return;
        int mid = start + (end - start) / 2;

        mergetSort(start, mid);
        mergetSort(mid + 1, end);
        for (int i = start; i <= end; i++)
            tmp[i] = A[i];

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (tmp[idx1] > tmp[idx2]) {
                A[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                A[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= mid) {
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
