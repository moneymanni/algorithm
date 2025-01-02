package doIt.day212;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {

    private static int N;
    private static Meeting[] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        int cnt = 0, end = -1;

        for (int i = 0; i < N; i++) {
            if (meetings[i].startTime >= end) {
                end = meetings[i].endTime;
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting obj) {
            if (this.endTime == obj.endTime)
                return this.startTime - obj.startTime;

            return this.endTime - obj.endTime;
        }
    }
}
