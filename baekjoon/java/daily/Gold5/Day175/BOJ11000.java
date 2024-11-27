package Gold5.Day175;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(S, T);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].endTime);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].startTime)
                pq.poll();

            pq.offer(lectures[i].endTime);
        }

        bw.write(pq.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Lecture implements Comparable<Lecture> {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture obj) {
            if (this.startTime == obj.startTime)
                return this.endTime - obj.endTime;

            return this.startTime - obj.startTime;
        }
    }
}
