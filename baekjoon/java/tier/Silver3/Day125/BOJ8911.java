package Silver3.Day125;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int result = 0;
        if (arr.length == 1)
            result = arr[0];
        else
            result = arr[(arr.length - 1) / 2];

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
