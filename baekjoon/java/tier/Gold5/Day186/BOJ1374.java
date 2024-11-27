package Gold5.Day186;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int LN = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(LN, startTime, endTime);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxRoom = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= lectures[i].startTime)
                pq.poll();

            pq.offer(lectures[i].endTime);
            maxRoom = Math.max(maxRoom, pq.size());
        }

        bw.write(maxRoom + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Lecture implements Comparable<Lecture> {
        int lectureNum;
        int startTime;
        int endTime;

        public Lecture(int lectureNum, int startTime, int endTime) {
            this.lectureNum = lectureNum;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture obj) {
            if (this.startTime != obj.startTime)
                return this.startTime - obj.startTime;

            return this.endTime - obj.endTime;
        }
    }
}
