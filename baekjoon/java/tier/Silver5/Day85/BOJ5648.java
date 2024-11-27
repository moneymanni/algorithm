package Silver5.Day85;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        int idx = 0;
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            arr[idx++] = Long.parseLong(sb.reverse().toString());
            sb.setLength(0);
            N--;
        }

        while (N > 0) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
                arr[idx++] = Long.parseLong(sb.reverse().toString());
                sb.setLength(0);
                N--;
            }
        }

        Arrays.sort(arr);

        for (long num : arr)
            bw.write(num + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
