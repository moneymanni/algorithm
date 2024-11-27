package Gold5.Day186;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1911 {
    private static int N, L;
    private static int puddleCnt;
    private static Puddle[] puddles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        puddles = new Puddle[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            puddles[i] = new Puddle(start, end);
        }

        fixDirtRoad();

        bw.write(puddleCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void fixDirtRoad() {
        PriorityQueue<Puddle> pq = new PriorityQueue<>();

        for (int i = 0; i < puddles.length; i++)
            pq.offer(new Puddle(puddles[i].start, puddles[i].end));

        puddleCnt = 0;
        int maxPos = 0;

        while (!pq.isEmpty()) {
            Puddle currPuddle = pq.poll();

            if (currPuddle.end < maxPos)
                continue;

            if (currPuddle.start > maxPos)
                maxPos = currPuddle.start;

            int remain = (currPuddle.end - maxPos) % L;
            puddleCnt += (currPuddle.end - maxPos) / L;
            maxPos = currPuddle.end;

            if (remain != 0) {
                puddleCnt++;
                maxPos += L - remain;
            }
        }
    }

    static class Puddle implements Comparable<Puddle> {
        int start;
        int end;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Puddle obj) {
            if (this.start != obj.start)
                return this.start - obj.start;

            return obj.end - this.end;
        }
    }
}
