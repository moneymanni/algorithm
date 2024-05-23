package Silver3.Day124;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2852 {
    private static final int TOTAL_GAME_TIME_SECONDS = 48 * 60;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N =Integer.parseInt(br.readLine());

        int[] totalTime = new int[]{0, 0};
        int[] score = new int[]{0, 0};
        int prevTime = 0;
        int leadTime = -1;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken()) - 1;
            String[] timeParts = st.nextToken().split(":");
            int currTime = convertToSeconds(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));

            if (leadTime != -1)
                totalTime[leadTime] += currTime - prevTime;

            score[teamNum]++;

            if (score[0] > score[1])
                leadTime = 0;
            else if (score[0] < score[1])
                leadTime = 1;
            else
                leadTime = -1;

            prevTime = currTime;
        }

        if (leadTime != -1)
            totalTime[leadTime] += TOTAL_GAME_TIME_SECONDS - prevTime;

        bw.write(toStringTime(totalTime[0]) + "\n" + toStringTime(totalTime[1]));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int convertToSeconds(int minutes, int seconds) {
        return minutes * 60 + seconds;
    }

    private static String toStringTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
