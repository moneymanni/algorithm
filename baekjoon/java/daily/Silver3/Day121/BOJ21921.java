package Silver3.Day121;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 누적합
//        st = new StringTokenizer(br.readLine());
//        int[] visitors = new int[N];
//        int[] prefixSum = new int[N + 1];
//        for (int i = 0; i < N; i++) {
//            visitors[i] = Integer.parseInt(st.nextToken());
//            prefixSum[i+1] = prefixSum[i] + visitors[i];
//        }
//
//        int maxVisitor = Integer.MIN_VALUE;
//        int cnt = 0;
//        for (int i = X; i <= N; i++) {
//            int visitor = prefixSum[i] - prefixSum[i-X];
//
//            if (visitor > maxVisitor) {
//                maxVisitor = visitor;
//                cnt = 1;
//            } else if (visitor == maxVisitor) {
//                cnt++;
//            }
//        }
//
//        if (maxVisitor == 0)
//            bw.write("SAD");
//        else
//            bw.write(String.format("%d\n%d", maxVisitor, cnt));

        // 슬라이딩 윈도우
        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++)
            visitors[i] = Integer.parseInt(st.nextToken());

        int windowSum = 0;
        for (int i = 0; i < X; i++)
            windowSum += visitors[i];
        int maxVisitor = windowSum;
        int cnt = 1;

        for (int i = X; i < N; i++) {
            windowSum += visitors[i] - visitors[i - X];
            if (windowSum > maxVisitor) {
                maxVisitor = windowSum;
                cnt = 1;
            } else if (windowSum == maxVisitor) {
                cnt++;
            }
        }

        if (maxVisitor == 0)
            bw.write("SAD");
        else
            bw.write(String.format("%d\n%d", maxVisitor, cnt));

        br.close();
        bw.flush();
        bw.close();
    }
}
