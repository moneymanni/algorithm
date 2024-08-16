package Silver1.Day161;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20529 {
    private static final int MBTI_LENGTH = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String[] arr = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = st.nextToken();

            int min = Integer.MAX_VALUE;

            outer: for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        min = Math.min(min,findPsychologicalDist(arr[i], arr[j], arr[k]));

                        if (min == 0)
                            break outer;
                    }
                }
            }

            bw.write(min + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findPsychologicalDist(String target1, String target2, String target3) {
        int dist = 0;

        for (int i = 0; i < MBTI_LENGTH; i++) {
            dist += target1.charAt(i) != target2.charAt(i) ? 1 : 0;
            dist += target1.charAt(i) != target3.charAt(i) ? 1 : 0;
            dist += target2.charAt(i) != target3.charAt(i) ? 1 : 0;
        }

        return dist;
    }
}
