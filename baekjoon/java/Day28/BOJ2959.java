package Day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // A < B < C < D라고 가정했을 때,
        // B -> D -> C -> A로 이동해야 가장 큰 직사각형을 만들 수 있다.
        // 그러므로 C와 A가 직사각형의 선분의 길이다.
        Arrays.sort(arr);
        System.out.println(arr[0] * arr[2]);

        br.close();
    }
}
