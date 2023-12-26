package Day52;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int N = 5;
//        String[] blackboard = new String[N];
//        for (int i = 0; i < blackboard.length; i++)
//            blackboard[i] = br.readLine();
//
//        int max = Arrays.stream(blackboard)
//                .mapToInt(String::length)
//                .max()
//                .orElse(0);
//
//        for (int i = 0; i < max; i++) {
//            for (int j = 0; j < blackboard.length; j++) {
//                try {
//                    bw.write(blackboard[j].charAt(i) + "");
//                } catch (StringIndexOutOfBoundsException e) {
//                    continue;
//                }
//            }
//        }

        int N = 5, M = 15;
        char[][] blackboard = new char[N][M];
        int max = 0;
        for (int i = 0; i < blackboard.length; i++) {
            String line = br.readLine();
            max = Math.max(max, line.length());
            for (int j = 0; j < line.length(); j++)
                blackboard[i][j] = line.charAt(j);
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < blackboard.length; j++) {
                if (blackboard[j][i] == '\0') continue;
                bw.write(blackboard[j][i] + "");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
