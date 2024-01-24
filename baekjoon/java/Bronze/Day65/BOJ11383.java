package Day65;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11383 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] str = new String[N];
        String[] comp = new String[N];
        for (int i = 0; i < N; i++)
            str[i] = br.readLine();
        for (int i = 0; i < N; i++)
            comp[i] = br.readLine();

        boolean isEyfa = true;
        for (int i = 0; i < N; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str[i].length(); j++)
                sb.append(str[i].charAt(j)).append(str[i].charAt(j));

            if (!sb.toString().equals(comp[i]))
                isEyfa = false;
        }

        if (isEyfa)
            bw.write("Eyfa");
        else
            bw.write("Not Eyfa");

        br.close();
        bw.flush();
        bw.close();
    }
}
