package Silver2.Day147;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];

            for (int i = 1; i <= n; i++)
                teams[i - 1] = new Team(i, k);

            for (int l = 1; l <= m; l++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                teams[i - 1].submit(j, s, l);
            }

            Arrays.sort(teams);

            for (int i = 1; i <= n; i++) {
                if (teams[i - 1].id == t) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Team implements Comparable<Team> {
        int id;
        int[] scores;
        int submitNum;
        int lastSubmit;
        int totalScore;

        public Team(int id, int problemNum) {
            this.id = id;
            scores = new int[problemNum + 1];

            submitNum = 0;
            lastSubmit = -1;
            totalScore = 0;
        }

        public void submit(int pNum, int score, int time) {
            if (score > scores[pNum]) {
                totalScore += score - scores[pNum];
                scores[pNum] = score;
            }
            submitNum++;
            lastSubmit = time;
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalScore != o.totalScore)
                return o.totalScore - this.totalScore;
            else if (this.submitNum != o.submitNum)
                return this.submitNum - o.submitNum;
            else
                return this.lastSubmit - o.lastSubmit;
        }
    }
}
