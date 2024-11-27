package Silver5.Day77;

import java.io.*;
import java.util.Arrays;

public class BOJ11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for (int i = N - 1; i >= 0; i--)
            bw.write(arr[i] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
