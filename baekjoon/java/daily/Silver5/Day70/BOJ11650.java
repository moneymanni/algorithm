package Silver5.Day70;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static int[][] coordinates, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        coordinates = new int[N][2];
        temp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        for (int[] ints : coordinates) {
            bw.write(String.format("%d %d\n", ints[0], ints[1]));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void mergeSort (int start, int end) {
        if (end - start < 1)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++)
            temp[i] = Arrays.copyOf(coordinates[i], coordinates[i].length);

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if ((temp[idx1][0] > temp[idx2][0])
                    || (temp[idx1][0] == temp[idx2][0]) && temp[idx1][1] > temp[idx2][1]) {
                coordinates[k] = Arrays.copyOf(temp[idx2], temp[idx2].length);
                k++;
                idx2++;
            } else {
                coordinates[k] = Arrays.copyOf(temp[idx1], temp[idx1].length);
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            coordinates[k] = Arrays.copyOf(temp[idx1], temp[idx1].length);
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            coordinates[k] = Arrays.copyOf(temp[idx2], temp[idx2].length);
            k++;
            idx2++;
        }
    }
}
