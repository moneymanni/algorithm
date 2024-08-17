package Silver1.Day162;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            int[] rectangle1 = new int[4];
            int[] rectangle2 = new int[4];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < rectangle1.length; j++)
                rectangle1[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < rectangle2.length; j++)
                rectangle2[j] = Integer.parseInt(st.nextToken());

            String answer = identifyType(rectangle1, rectangle2);

            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String identifyType(int[] p1, int[] p2) {

        // p1 == x2 || q1 == y2|| p2 == x1 || y1 == q2
        if (p1[2] < p2[0] || p1[3] < p2[1] || p2[2] < p1[0] || p2[3] < p1[1])
            return "d";
        else if ((p1[0] == p2[2] && p1[1] == p2[3])
                || (p1[0] == p2[2] && p1[3] == p2[1])
                || (p1[2] == p2[0] && p1[3] == p2[1])
                || (p1[2] == p2[0] && p1[1] == p2[3]))
            return "c";
        else if (p1[2] == p2[0] || p1[3] == p2[1] || p1[0] == p2[2] || p1[1] == p2[3])
            return "b";
        else
            return "a";
    }
}
