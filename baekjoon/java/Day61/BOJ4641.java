package Day61;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        while (!(line = br.readLine()).equals("-1")) {
            st = new StringTokenizer(line);

            List<Integer> list = new ArrayList<>();
            int input;
            while ((input = Integer.parseInt(st.nextToken())) != 0) {
                list.add(input);
            }

            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j)
                        continue;

                    if (list.get(i) * 2 == list.get(j)) {
                        cnt++;
                        break;
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
