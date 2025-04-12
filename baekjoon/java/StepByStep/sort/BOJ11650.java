package StepByStep.sort;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11650 {

    private static int[][] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        temp = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        for (int[] nums : arr) {
            bw.write(String.format("%d %d\n", nums[0], nums[1]));
        }

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
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }

        int k = start;
        int idx1 = start, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1][0] < temp[idx2][0]) {
                arr[k][0] = temp[idx1][0];
                arr[k++][1] = temp[idx1++][1];
            } else if (temp[idx1][0] > temp[idx2][0]) {
                arr[k][0] = temp[idx2][0];
                arr[k++][1] = temp[idx2++][1];
            } else {
                if (temp[idx1][1] < temp[idx2][1]) {
                    arr[k][0] = temp[idx1][0];
                    arr[k++][1] = temp[idx1++][1];
                } else {
                    arr[k][0] = temp[idx2][0];
                    arr[k++][1] = temp[idx2++][1];
                }
            }
        }

        while (idx1 <= mid) {
            arr[k][0] = temp[idx1][0];
            arr[k++][1] = temp[idx1++][1];
        }
        while (idx2 <= end) {
            arr[k][0] = temp[idx2][0];
            arr[k++][1] = temp[idx2++][1];
        }
    }
}
