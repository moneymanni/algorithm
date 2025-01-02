package doIt.day202;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    shift(arr, j, i);
                    arr[j] = temp;
                    break;
                }
            }
        }

        int[] addArr = new int[N];
        int sum = arr[0];

        addArr[0] = arr[0];

        for (int i = 1; i < N; i++) {
            addArr[i] = addArr[i - 1] + arr[i];
            sum += addArr[i];
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void shift(int[] arr, int startIdx, int endIdx) {
        int prev = arr[startIdx];

        for (int i = startIdx + 1; i <= endIdx; i++) {
            int temp = arr[i];
            arr[i] = prev;
            prev = temp;
        }
    }
}
