package Day58;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1268 {
    public static final int NUM_OF_GRADES = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int studentNum = Integer.parseInt(br.readLine());
        int[][] student = new int[studentNum][NUM_OF_GRADES];
        for (int i = 0; i < studentNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM_OF_GRADES; j++)
                student[i][j] = Integer.parseInt(st.nextToken());
        }

        int maxStudent = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < studentNum; i++) {
            Set<Integer> sameClass = new HashSet<>();

            for (int j = 0; j < NUM_OF_GRADES; j++) {
                for (int k = 0; k < studentNum; k++) {
                    if (student[i][j] == student[k][j] && k != i)
                        sameClass.add(k);
                }
            }

            if (maxStudent < sameClass.size()) {
                maxStudent = sameClass.size();
                result = i;
            }
        }

        bw.write(++result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
