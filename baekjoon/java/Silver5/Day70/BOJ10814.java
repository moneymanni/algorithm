package Silver5.Day70;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    public static String[][] memberInfo, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        memberInfo = new String[N][2
                ];
        tmp = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memberInfo[i][0] = st.nextToken();
            memberInfo[i][1] = st.nextToken();
        }

        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            bw.write(memberInfo[i][0] + " " + memberInfo[i][1] + "\n");
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
            tmp[i] = Arrays.copyOf(memberInfo[i], memberInfo[i].length);

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (Integer.parseInt(tmp[idx1][0]) > Integer.parseInt(tmp[idx2][0])) {
                memberInfo[k] = Arrays.copyOf(tmp[idx2], tmp[idx2].length);
                k++;
                idx2++;
            } else {
                memberInfo[k] = Arrays.copyOf(tmp[idx1], tmp[idx1].length);
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            memberInfo[k] = Arrays.copyOf(tmp[idx1], tmp[idx1].length);
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            memberInfo[k] = Arrays.copyOf(tmp[idx2], tmp[idx2].length);
            k++;
            idx2++;
        }
    }
}
