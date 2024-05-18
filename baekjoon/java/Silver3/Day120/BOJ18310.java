package Silver3.Day120;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        if (N % 2 == 0)
            bw.write(A[N/2-1] + "");
        else
            bw.write(A[N/2] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
