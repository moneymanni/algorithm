package Silver5.Day71;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11651 {
    public static int[][] coordinate, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        coordinate = new int[N][2];
        temp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++)
            bw.write(String.format("%d %d\n", coordinate[i][0], coordinate[i][1]));

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

        for (int i = start; i <= end; i++) {
            temp[i][0] = coordinate[i][0];
            temp[i][1] = coordinate[i][1];
        }

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while ((idx1 <= mid && idx2 <= end)) {
            if ((temp[idx1][1] > temp[idx2][1])
                    || (temp[idx1][1] == temp[idx2][1] && temp[idx1][0] > temp[idx2][0])) {
                coordinate[k][0] = temp[idx2][0];
                coordinate[k][1] = temp[idx2][1];
                k++;
                idx2++;
            } else {
                coordinate[k][0] = temp[idx1][0];
                coordinate[k][1] = temp[idx1][1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= mid) {
            coordinate[k][0] = temp[idx1][0];
            coordinate[k][1] = temp[idx1][1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            coordinate[k][0] = temp[idx2][0];
            coordinate[k][1] = temp[idx2][1];
            k++;
            idx2++;
        }
    }
}
