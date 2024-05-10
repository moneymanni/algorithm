package Silver3.Day118;

import java.io.*;

public class BOJ1431 {
    private static int N;
    private static String[] serialNums, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        serialNums = new String[N + 1];
        temp = new String[N + 1];

        for (int i = 1; i <= N; i++)
            serialNums[i] = br.readLine();

        mergeSort(1, N);

        for (int i = 1; i <= N; i++)
            bw.write(serialNums[i] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort (int start, int end) {
        if (end - start < 1)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++)
            temp[i] = serialNums[i];

        int k = start;
        int idx1 = start, idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (compare(temp[idx1], temp[idx2]) > 0)
                serialNums[k++] = temp[idx2++];
            else
                serialNums[k++] = temp[idx1++];
        }

        while (idx1 <= mid)
            serialNums[k++] = temp[idx1++];
        while (idx2 <= end)
            serialNums[k++] = temp[idx2++];
    }

    private static int compare (String str1, String str2) {
        int len = Integer.compare(str1.length(), str2.length());
        if (len != 0)
            return len;

        int str1Sum = 0, str2Sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            int ch1 = str1.charAt(i);
            int ch2 = str2.charAt(i);

            if (Character.isDigit(ch1))
                str1Sum += ch1 - '0';
            if (Character.isDigit(ch2))
                str2Sum += ch2 - '0';
        }

        if (str1Sum - str2Sum != 0)
            return str1Sum - str2Sum;

        return str1.compareTo(str2);
    }
}
