package Day8;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int numOfParticipants = L * P;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++)
            bw.write( (Integer.parseInt(st.nextToken()) - numOfParticipants) + " ");
        bw.flush();
        bw.close();
    }
}
