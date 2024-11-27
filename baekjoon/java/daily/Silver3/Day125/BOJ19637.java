package Silver3.Day125;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Title[] titles = new Title[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int level = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                mid = (left + right) / 2;

                if (titles[mid].level < level)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            sb.append(titles[left].title).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    static class Title {
        String title;
        int level;

        public Title(String title, int level) {
            this.title = title;
            this.level = level;
        }
    }
}