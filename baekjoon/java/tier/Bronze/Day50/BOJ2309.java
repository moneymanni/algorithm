package Day50;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] heightOfDwarves = new int[9];
        for (int i = 0; i < heightOfDwarves.length; i++)
            heightOfDwarves[i] = Integer.parseInt(br.readLine());

        // 버블 정렬
        for (int i = 0; i < heightOfDwarves.length - 1; i++) {
            for (int j = 0; j < heightOfDwarves.length - 1 - i; j++) {
                if (heightOfDwarves[j] > heightOfDwarves[j + 1]) {
                    int temp = heightOfDwarves[j];
                    heightOfDwarves[j] = heightOfDwarves[j + 1];
                    heightOfDwarves[j + 1] = temp;
                }
            }
        }

        // 조합 하나를 찾은 이후에도 계속 반복하여 다른 조합을 찾기 때문에 오답으로 나왔다.
        int sum = Arrays.stream(heightOfDwarves).sum();
        for (int i = 0; i < heightOfDwarves.length; i++) {
            for (int j = i + 1; j < heightOfDwarves.length; j++) {
                if (sum - (heightOfDwarves[i] + heightOfDwarves[j]) == 100) {
                    for (int k = 0; k < heightOfDwarves.length; k++) {
                        if (k == i || k == j)
                            continue;
                        bw.write(heightOfDwarves[k] + "\n");
                    }
                    bw.flush();
                    return;
                }
            }
        }

        br.close();
        bw.close();
    }
}
