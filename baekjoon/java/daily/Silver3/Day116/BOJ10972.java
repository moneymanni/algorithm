package Silver3.Day116;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        if (next(A)) {
            for (int num : A)
                bw.write(num + " ");
        } else {
            bw.write("-1");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean next(int[] A) {
        int i = A.length - 1;

        while (i > 0 && A[i-1] >= A[i])
            i -= 1;

        if (i <= 0)
            return false;

        int j = A.length - 1;

        while (A[i-1] >= A[j])
            j -= 1;

        int temp = A[j];
        A[j] = A[i-1];
        A[i-1] = temp;

        j = A.length - 1;

        while (i < j) {
            temp = A[j];
            A[j] = A[i];
            A[i] = temp;
            i++; j--;
        }

        return true;
    }
}
