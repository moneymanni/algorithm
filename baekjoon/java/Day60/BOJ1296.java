package Day60;

import java.io.*;
import java.util.Arrays;

public class BOJ1296 {
    public static final char[] FOUR_VARIABLES = {'L', 'O', 'V', 'E'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] teamName = new String[N];
        for (int i = 0; i < N; i++)
            teamName[i] = br.readLine();

        int[] teamScore = new int[N];

        Arrays.sort(teamName);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            teamScore[i] = rank(name, teamName[i]);
            max = Math.max(max, teamScore[i]);
        }

        for (int i = 0; i < N; i++)  {
            if (max == teamScore[i]) {
                bw.write(teamName[i]);
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int rank (String teamName, String str) {
        int[] cnt = new int[FOUR_VARIABLES.length];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < FOUR_VARIABLES.length; j++) {
                if (str.charAt(i) == FOUR_VARIABLES[j])
                    cnt[j]++;
            }
        }

        for (int i = 0; i < teamName.length(); i++) {
            for (int j = 0; j < FOUR_VARIABLES.length; j++) {
                if (teamName.charAt(i) == FOUR_VARIABLES[j])
                    cnt[j]++;
            }
        }

        int score = 1;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = i + 1; j < cnt.length; j++) {
                score *= cnt[i] + cnt[j];
            }
        }

        return score % 100;
    }
}
