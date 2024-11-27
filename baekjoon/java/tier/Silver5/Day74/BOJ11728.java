package Silver5.Day74;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + M];
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[idx++] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arr[idx++] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int i : arr)
            bw.write(i + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
