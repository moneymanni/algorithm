package Silver4.Day102;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
//            int N = Integer.parseInt(br.readLine());
//
//            st = new StringTokenizer(br.readLine());
//            int[] arr = new int[N];
//            for (int i = 0; i < N; i++)
//                arr[i] = Integer.parseInt(st.nextToken());
//
//            int maxValue = Integer.MIN_VALUE;
//            for (int i = 0; i < N; i++) {
//                int max = Integer.MIN_VALUE;
//                int temp = 0;
//                for (int j = i; j < N; j++) {
//                    temp += arr[j];
//                    max = Math.max(max, temp);
//                }
//                maxValue = Math.max(maxValue, max);
//            }
//
//            bw.write(maxValue + "\n");


            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int temp = arr[0];
            int max = arr[0];
            for (int i = 1; i < N; i++) {
                temp = Math.max(arr[i], temp + arr[i]);
                max = Math.max(max, temp);
            }

            bw.write(max + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
