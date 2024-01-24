package Day47;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 운동시간
        int m = Integer.parseInt(st.nextToken());  // 최소 맥박
        int M = Integer.parseInt(st.nextToken());  // 최대 맥박
        int T = Integer.parseInt(st.nextToken());  // 운동 시, 맥박 증가량
        int R = Integer.parseInt(st.nextToken());  // 휴식 시, 맥박 감소량

        int X = m;  // 현재 맥박
        int time = 0;
        int exerciseTime = 0;
        while (exerciseTime != N) {
            time++;

            if (X + T <= M) {
                X += T;
                exerciseTime++;
            } else {
                X = Math.max(X - R, m);
            }

            if (X + T > M && X == m)
                break;
        }

        if (exerciseTime != N)
            bw.write("-1");
        else
            bw.write(time + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
