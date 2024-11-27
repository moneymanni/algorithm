package Silver1.Day157;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
    private static Queue<Integer> truckQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            truckQueue.add(Integer.parseInt(st.nextToken()));

        int result = crossBridgeWithTrucks(w, L);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int crossBridgeWithTrucks(int weight, int len) {
        Queue<Integer> bridgeQueue = new LinkedList<>();

        int time = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < weight; i++)
            bridgeQueue.add(0);

        while (!bridgeQueue.isEmpty()) {
            time++;
            bridgeWeight -= bridgeQueue.remove();

            if (!truckQueue.isEmpty()) {
                if (truckQueue.peek() + bridgeWeight <= len) {
                    bridgeWeight += truckQueue.peek();
                    bridgeQueue.add(truckQueue.remove());
                } else {
                    bridgeQueue.add(0);
                }
            }
        }

        return time;
    }
}
