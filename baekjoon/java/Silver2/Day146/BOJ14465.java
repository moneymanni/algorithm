package Silver2.Day146;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] trafficLights = new int[N + 1];

        for (int i = 0; i < B; i++)
            trafficLights[Integer.parseInt(br.readLine())] = 1;

        int cnt = 0;

        for (int i = 1; i <= K; i++)
            cnt += trafficLights[i];

        int min = cnt;

        for (int i = 2; i<= N - K + 1; i++) {
            cnt -= trafficLights[i - 1];
            cnt += trafficLights[i + K - 1];

            min = Math.min(min, cnt);
        }

        bw.write(min + "");

//        boolean[] isTrafficLight = new boolean[N + 1];
//
//        Arrays.fill(isTrafficLight, true);
//
//        for (int i = 0; i < B; i++)
//            isTrafficLight[Integer.parseInt(br.readLine())] = false;
//
//        int cnt = 0;
//
//        for (int i = 1; i <= K; i++) {
//            if (!isTrafficLight[i])
//                cnt++;
//        }
//
//        int min = cnt;
//
//        for (int i = 2; i <= N - K + 1; i++) {
//            if (!isTrafficLight[i - 1] && isTrafficLight[i + K - 1])
//                cnt--;
//            if (!isTrafficLight[i + K - 1] && isTrafficLight[i - 1])
//                cnt++;
//
//            min = Math.min(min, cnt);
//        }
//
//        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
