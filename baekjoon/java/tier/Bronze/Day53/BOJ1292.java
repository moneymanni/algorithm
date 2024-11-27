package Day53;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // B 만큼의 수열을 만들어 더하는 방법
//        int[] section = new int[B+1];
//        int idx = 1, cnt = 1;
//        for (int i = 1; i <= B; i++) {
//            if (cnt < i)
//                cnt += ++idx;
//
//            section[i] = idx;
//        }
//
//        int result = 0;
//        for (int i = A; i <= B; i++)
//            result += section[i];
//
//        bw.write(result + "");


        // B 까지의 구간 합을 구하여 A-1 까지의 구간 합을 빼는 방법
        int[] prefixSum = new int[B+1];
        int idx = 1, cnt = 1;
        for (int i = 1; i <= B; i++) {
            if (cnt < i)
                cnt += ++idx;

            prefixSum[i] = prefixSum[i-1] + idx;
        }

        int result = prefixSum[B] - prefixSum[A - 1];
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
