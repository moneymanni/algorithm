package doIt.day204;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1517 {

    private static int N;
    private static long result;
    private static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        result = 0;
        arr = new int[N + 1];
        temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int idx1 = start, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1] <= temp[idx2]) {
                arr[k++] = temp[idx1++];
            } else {
                result += idx2 - k;
                arr[k++] = temp[idx2++];
            }
        }

        while (idx1 <= mid) {
            arr[k++] = temp[idx1++];
        }

        while (idx2 <= end) {
            arr[k++] = temp[idx2++];
        }
    }
}
