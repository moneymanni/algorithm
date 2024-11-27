package Silver5.Day86;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++)
            names.add(br.readLine());

        int result = 0;
        switch (game) {
            case "Y":
                result = names.size();
                break;
            case "F":
                result = names.size() / 2;
                break;
            case "O":
                result = names.size() / 3;
                break;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
