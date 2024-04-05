package Silver4.Day106;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lamps = new int[M];
        for (int i = 0; i < M; i++)
            lamps[i] = Integer.parseInt(st.nextToken());

        int maxDistance = lamps[0];
        for (int i = 1; i < M; i++)
            maxDistance = Math.max(maxDistance, (lamps[i] - lamps[i-1] + 1) / 2);

        maxDistance = Math.max(maxDistance, N - lamps[M-1]);

        bw.write(maxDistance + "");

//        int answer = 0;
//        int low = 0, high = N;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            boolean flag = true;
//
//            int point = 0;
//            for (int i = 0; i < M; i++) {
//                if (lamps[i] - mid <= point)
//                    point = lamps[i] + mid;
//                else
//                    flag = false;
//            }
//
//            if (N - point > 0)
//                flag = false;
//            else
//                flag = true;
//
//            if (flag) {
//                answer = mid;
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//
//        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
