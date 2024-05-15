package Silver3.Day119;

import java.io.*;
import java.util.Arrays;

public class BOJ4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int len = (int) Math.pow(3, N);

            char[] line = new char[len];
            Arrays.fill(line, '-');

            cantorianSet(line, 0, len);

            for (int i = 0; i < len; i++)
                sb.append(line[i]);
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cantorianSet (char[] line, int start, int len) {
        if (len == 1)
            return;

        int size = len / 3;

        for (int i = start + size; i < start + 2 * size; i++)
            line[i] = ' ';

        cantorianSet(line, start, size);
        cantorianSet(line, start + 2 * size, size);
    }
}
