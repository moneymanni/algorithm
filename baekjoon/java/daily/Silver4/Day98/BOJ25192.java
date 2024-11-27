package Silver4.Day98;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> users = new HashSet<>();
        int cnt = 0;
        while (N-- > 0) {
            String line = br.readLine();

            if (line.equals("ENTER")) {
                if (!users.isEmpty())
                    cnt += users.size();

                users = new HashSet<>();
                continue;
            }

            users.add(line);
        }
        cnt += users.size();

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
