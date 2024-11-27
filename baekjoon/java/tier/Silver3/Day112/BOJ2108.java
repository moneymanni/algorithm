package Silver3.Day112;

import java.io.*;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int mean = findMean(arr);
        int median = findMedian(arr);
        int mode = findMode(arr);
        int range = findRange(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(mean).append('\n').append(median).append('\n');
        sb.append(mode).append('\n').append(range);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int findMean(int[] arr) {
        double sum = Arrays.stream(arr).sum();

        return (int) Math.round(sum / arr.length);
    }

    static int findMedian(int[] arr) {
        return arr[arr.length / 2];
    }

    static int findMode(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxCnt = 0;

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            maxCnt = Math.max(maxCnt, frequency.get(num));
        }

        TreeSet<Integer> modes = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxCnt)
                modes.add(entry.getKey());
        }

        if (modes.size() >= 2)
            return new ArrayList<>(modes).get(1);
        else
            return modes.first();
    }

    static int findRange(int[] arr) {
        return Math.abs(arr[arr.length-1] - arr[0]);
    }
}
