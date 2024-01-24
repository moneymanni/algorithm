package Silver5.Day69;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ1181 {
    public static String[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> A = new HashSet<>();
        while (N-- > 0)
            A.add(br.readLine());

        int num = A.size();
        arr = new String[num];
        tmp = new String[num];

        arr = A.toArray(new String[0]);

        mergetSort(0, num - 1);
        for (int i = 0; i < num; i++)
            bw.write(arr[i] + "\n");

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
            tmp[i] = arr[i];

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if ((tmp[idx1].length() > tmp[idx2].length())
                    || (tmp[idx1].length() == tmp[idx2].length() && tmp[idx1].compareTo(tmp[idx2]) > 0)) {
                arr[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
