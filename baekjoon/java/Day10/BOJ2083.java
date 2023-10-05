package Day10;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (name.charAt(0) == '#' && age == 0 && weight == 0)
                break;

            bw.write(age > 17 || weight >= 80 ? name + " Senior\n" : name + " Junior\n");
        }

        bw.flush();
        bw.close();
    }
}
