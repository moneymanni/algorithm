package StepByStep.twopointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1450 {

    private static int N, C;
    private static int[] weight;
    private static ArrayList<Integer> left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        left = new ArrayList<>();
        right = new ArrayList<>();

        comb(left, 0, N / 2, 0);
        comb(right, N / 2, N, 0);

        right.sort(Comparator.comparingInt(a -> a));

        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < left.size(); i++) {
            idx = upperBound(0, right.size() - 1, left.get(i));
            cnt += idx + 1;
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int upperBound(int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (right.get(mid) <= C - value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static void comb(List<Integer> list, int start, int end, int sum) {
        if (sum > C) {
            return;
        }

        if (start == end) {
            list.add(sum);
            return;
        }

        comb(list, start + 1, end, sum);
        comb(list, start + 1, end, sum + weight[start]);
    }
}
