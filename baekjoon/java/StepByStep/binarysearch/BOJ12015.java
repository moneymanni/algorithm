package StepByStep.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12015 {

    private static int N;
    private static int[] A, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch() {
        int len = 1;
        arr[0] = A[0];

        for (int i = 1; i < N; i++) {
            int key = A[i];

            if (arr[len - 1] < key) {
                len++;
                arr[len - 1] = key;
            } else {
                int low = 0;
                int high = len;

                while (low < high) {
                    int mid = (low + high) >>> 1;

                    if (arr[mid] < key) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                arr[low] = key;
            }
        }

        return len;
    }
}
