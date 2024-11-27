package Silver5.Day87;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ24039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = findPrimeNums(1, 10000);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = list.get(i) * list.get(i + 1);
            if (result > N) {
                bw.write(result + "");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static List<Integer> findPrimeNums (int minNum, int maxNum) {
        if (minNum < 2)
            minNum = 2;

        List<Integer> list = new ArrayList<>();

        int i, j;
        for (i = minNum; i <= maxNum; i++) {
            for (j = minNum; j < i; j++) {
                if (i % j == 0)
                    break;
            }

            if (i == j)
                list.add(i);
        }

        return list;
    }
}
