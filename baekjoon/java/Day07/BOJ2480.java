package Day7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dice = new int[3];
        for (int i = 0; i < 3; i++)
            dice[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(dice);

        int result = 0;
        if (dice[0] == dice[2])
            result = 10000 + dice[0]*1000;
        else if (dice[0] == dice[1] || dice[1] == dice[2])
            result = 1000 + dice[1]*100;
        else
            result = dice[2]*100;
        bw.write(String.valueOf(result));

        br.close();
        bw.close();

//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());

//        int result = 0;
//        if (A == B && B == C)
//            result = 10000 + A*1000;
//        else if (A == B || A == C)
//            result = 1000 + A*100;
//        else if (B == C)
//            result = 1000 + B*100;
//        else
//            result = Math.max(A, B) > Math.max(B, C) ? Math.max(A, B) * 100 : Math.max(B, C) * 100;
//        bw.write(String.valueOf(result));
//
//        br.close();
//        bw.close();
    }
}
