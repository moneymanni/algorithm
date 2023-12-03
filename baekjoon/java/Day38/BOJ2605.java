package Day38;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfStudents = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] drawnNums = new int[numOfStudents];
        for (int i = 0; i < numOfStudents; i++)
            drawnNums[i] = Integer.parseInt(st.nextToken());

        // 번호가 0이면 뒷 줄에 서면 된다.
        // 그러나 1~이라면, 숫자만큼 앞에 가야하고 나머지 뒷 줄은 밀리게 된다.
        // 0 1 1 3
        int[] result = new int[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            int num = drawnNums[i];

            if (num == 0) {
                result[i] = i + 1;
            } else {
                for (int j = numOfStudents - 1; j > i - num ; j--)
                    result[j] = result[j-1];

                result[i-num] = i + 1;
            }
        }

        for (int num : result)
            bw.write(num + " ");

        br.close();
        bw.close();
    }
}
