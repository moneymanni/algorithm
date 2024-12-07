package doit.day204;

import java.io.*;

public class BOJ2751 {

    private static int N;
    private static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        temp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        // int mid = (start + end) / 2;
        int mid = start + (end - start) / 2;  // 오버플로우 방지, 더 안전한 방식

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int idx1 = start, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1] < temp[idx2]) {
                arr[k++] = temp[idx1++];
            } else {
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
