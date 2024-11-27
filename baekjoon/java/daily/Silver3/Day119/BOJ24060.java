package Silver3.Day119;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ24060 {
    private static int N, K, cnt, result;
    private static int[] A, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = -1;

        A = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(0, N - 1);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort (int p, int r) {
        if (cnt > K) return;
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private static void merge (int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] < A[j])
                temp[t++] = A[i++];
            else
                temp[t++] = A[j++];
        }

        while (i <= q)
            temp[t++] = A[i++];
        while (j <= r)
            temp[t++] = A[j++];

        i = p;
        t = 0;
        while (i <= r) {
            cnt++;

            if (cnt == K) {
                result = temp[t];
                break;
            }

            A[i++] = temp[t++];
        }
    }
}
