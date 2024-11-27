package Silver2.Day140;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Pillar[] arr = new Pillar[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int area = getArea(arr);

        bw.write(area + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getArea(Pillar[] pillars) {
        Arrays.sort(pillars);

        int len = pillars.length;
        int area = 0;
        int pivot = 0;

        for (int i = 0; i < len; i++)
            if (pillars[pivot].height < pillars[i].height) pivot = i;

        int maxHeightIdx = 0;
        for (int i = 0; i <= pivot; i++) {
            if (pillars[maxHeightIdx].height <= pillars[i].height) {
                area += (pillars[i].location - pillars[maxHeightIdx].location) * pillars[maxHeightIdx].height;
                maxHeightIdx = i;
            }
        }

        maxHeightIdx = len - 1;
        for (int i = len - 1; i >= pivot; i--) {
            if (pillars[maxHeightIdx].height <= pillars[i].height) {
                area += (pillars[maxHeightIdx].location - pillars[i].location) * pillars[maxHeightIdx].height;
                maxHeightIdx = i;
            }
        }

        area += pillars[pivot].height;

        return area;
    }

    static class Pillar implements Comparable<Pillar> {
        public int location;
        public int height;

        public Pillar(int location, int height) {
            this.location = location;
            this.height = height;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.location - o.location;
        }
    }
}
