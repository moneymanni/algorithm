package Silver1.Day149;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);

        int cnt = 0;
        int end = -1;

        for (Meeting meeting : meetings) {
            if (meeting.startTime >= end) {
                end = meeting.endTime;
                cnt++;
            }
        }

        bw.write(cnt + "");

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
        public int compareTo(Meeting o) {
            if (this.endTime != o.endTime)
                return Integer.compare(this.endTime, o.endTime);
            else
                return Integer.compare(this.startTime, o.startTime);
        }
    }
}
