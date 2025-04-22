package StepByStep.advanced2;

import java.io.*;
import java.util.*;

public class BOJ2108 {

    private static int N;
    private static int[] arr;
    private static int arithmeticMean, median, mode, range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        arithmeticMean = getArithmeticMean(arr);
        median = getMedian(arr);
        mode = getMode(arr);
        range = getRange(arr);

        bw.write(String.format("%d\n%d\n%d\n%d\n", arithmeticMean, median, mode, range));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getArithmeticMean(int[] arr) {
        double sum = Arrays.stream(arr).sum();
        return  (int) Math.round(sum / arr.length);
    }

    private static int getMedian(int[] arr) {
        return arr[arr.length / 2];
    }

    private static int getMode(int[] arr) {
        Map<Integer, Integer> modeMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            modeMap.put(arr[i], modeMap.getOrDefault(arr[i], 0) + 1);
            max = Math.max(max, modeMap.get(arr[i]));
        }

        TreeSet<Integer> modes = new TreeSet<>();

        for (Map.Entry<Integer, Integer> entry : modeMap.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }

        return modes.size() >= 2 ? new ArrayList<>(modes).get(1) : modes.first();
    }

    private static int getRange(int[] arr) {
        return Math.abs(arr[arr.length - 1] - arr[0]);
    }
}
