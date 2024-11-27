package Silver5.Day70;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] personInfo = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            personInfo[i][0] = Integer.parseInt(st.nextToken());
            personInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranking = new int[N];
        for (int i = 0; i < N; i++) {
            int x = personInfo[i][0];  // 몸무게
            int y = personInfo[i][1];  // 키

            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                int otherPersonWeight = personInfo[j][0];
                int otherPersonHeight = personInfo[j][1];

                if (otherPersonWeight > x && otherPersonHeight > y)
                    rank++;
            }

            for (int j = 0; j < N; j++) {
                if (i == j)
                    ranking[j] = rank;
            }
        }

        for (int i : ranking)
            bw.write(i + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
