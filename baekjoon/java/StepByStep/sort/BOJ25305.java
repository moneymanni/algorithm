package StepByStep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        insertionSort(arr);

        System.out.println(arr[k - 1]);

        br.close();
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            int value = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    idx = j + 1;
                    break;
                }
                if (j == 0) {
                    idx = 0;
                }
            }

            for (int j = i; j > idx; j--) {
                arr[j] = arr[j - 1];
            }

            arr[idx] = value;
        }
    }
}
