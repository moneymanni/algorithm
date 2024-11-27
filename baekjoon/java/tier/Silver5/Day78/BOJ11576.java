package Silver5.Day78;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[m];
        for (int i = 0; i < m; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int decimal = 0;
        for (int i = 0; i < m; i++)
            decimal += nums[i] * Math.pow(A, m-1-i);

        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            sb.insert(0, decimal % B + " ");
            decimal /= B;
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
