package Silver3.Day118;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10973 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        if (nextPermutation(A)) {
            for (int i = 0; i < N; i++)
                bw.write(A[i] + " ");
        } else {
            bw.write("-1");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean nextPermutation (int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] < a[i])
            i--;

        if (i == 0)
            return false;

        int j = a.length - 1;
        while (a[j] > a[i-1])
            j--;

        swap(a, i-1, j);

        j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap (int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
