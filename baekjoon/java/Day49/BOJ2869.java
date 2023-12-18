package Day49;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = 0;
        if (V - A <= 0)
            day = 1;
        else if (V - A <= A - B)
            day = 2;
        else
            day = (V - A) % (A - B) == 0 ?
                    (V - A) / (A - B) + 1 : (V - A) / (A - B) + 2;

        bw.write(day + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
