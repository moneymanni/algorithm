package StepByStep.greedyalgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13305 {

    private static int N;
    private static City[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cities = new City[N];

        for (int i = 0; i < N; i++) {
            cities[i] = new City();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            cities[i].nextDist = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i].oilPrice = Long.parseLong(st.nextToken());
        }

        long minCost = 0;
        long minPrice = cities[0].oilPrice;

        for (int i = 0; i < N - 1; i++) {
            minPrice = Math.min(minPrice, cities[i].oilPrice);
            minCost += minPrice * cities[i].nextDist;
        }

        bw.write(minCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class City {
        long oilPrice;
        long nextDist;

        public City() {}
    }
}
