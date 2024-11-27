package Silver5.Day81;

import java.io.*;
import java.util.Arrays;

public class BOJ15688 {
    public static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

//        mergeSort(0, N - 1);
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num).append('\n');

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void mergeSort (int start, int end) {
        if (end - start < 1)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid+1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1] > temp[idx2]) {
                arr[k] = temp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}
