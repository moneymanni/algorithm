package StepByStep.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2805 {

    private static int N, M;
    private static int min, max;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = 0;
        max = 0;
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int result = binarySearch();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch() {
        int answer = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            long rest = 0;

            for (int height : tree) {
                if (height > mid) {
                    rest += height - mid;
                }
            }

            if (rest >= M) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }
}
