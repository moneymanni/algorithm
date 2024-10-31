package Gold5.Day187;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ19598 {
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
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(meetings);

        int minRoom = findMinRoomCnt();

        bw.write(minRoom + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findMinRoomCnt() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(meetings[0].endTime);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= meetings[i].startTime)
                pq.poll();

            pq.offer(meetings[i].endTime);
        }

        return pq.size();
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
            if (this.startTime != obj.startTime)
                return this.startTime - obj.startTime;

            return this.endTime - obj.endTime;
        }
    }
}
