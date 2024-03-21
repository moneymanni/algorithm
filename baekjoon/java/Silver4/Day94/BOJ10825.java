package Silver4.Day94;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {
    public static String[][] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new String[N][4];
        temp = new String[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = st.nextToken();
        }

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++)
            bw.write(arr[i][0] + "\n");

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
            temp[i] = Arrays.copyOf(arr[i], arr[i].length);

        int k = start;
        int idx1 = start, idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            // 국어 점수 감소 순서
            if (Integer.parseInt(temp[idx1][1]) < Integer.parseInt(temp[idx2][1])) {
                arr[k++] = Arrays.copyOf(temp[idx2], temp[idx2++].length);
            } else if (Integer.parseInt(temp[idx1][1]) > Integer.parseInt(temp[idx2][1])) {
                arr[k++] = Arrays.copyOf(temp[idx1], temp[idx1++].length);
            } else {
                // 영어 점수 증가 순서
                if (Integer.parseInt(temp[idx1][2]) > Integer.parseInt(temp[idx2][2])) {
                    arr[k++] = Arrays.copyOf(temp[idx2], temp[idx2++].length);
                } else if (Integer.parseInt(temp[idx1][2]) < Integer.parseInt(temp[idx2][2])) {
                    arr[k++] = Arrays.copyOf(temp[idx1], temp[idx1++].length);
                } else {
                    // 수학 점수 감소 순서
                    if (Integer.parseInt(temp[idx1][3]) < Integer.parseInt(temp[idx2][3])) {
                        arr[k++] = Arrays.copyOf(temp[idx2], temp[idx2++].length);
                    } else if (Integer.parseInt(temp[idx1][3]) > Integer.parseInt(temp[idx2][3])) {
                        arr[k++] = Arrays.copyOf(temp[idx1], temp[idx1++].length);
                    } else {
                        // 이름 사전 순서
                        if (temp[idx1][0].compareTo(temp[idx2][0]) > 0) {
                            arr[k++] = Arrays.copyOf(temp[idx2], temp[idx2++].length);
                        } else {
                            arr[k++] = Arrays.copyOf(temp[idx1], temp[idx1++].length);
                        }
                    }
                }
            }
        }

        while (idx1 <= mid)
            arr[k++] = Arrays.copyOf(temp[idx1], temp[idx1++].length);
        while (idx2 <= end)
            arr[k++] = Arrays.copyOf(temp[idx2], temp[idx2++].length);
    }
}
