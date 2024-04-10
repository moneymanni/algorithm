package Silver4.Day107;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        String firstGroup = br.readLine();
        String secondGroup = br.readLine();

        int T = Integer.parseInt(br.readLine());

        if (T > N1 + N2)
            T = N1 + N2 - 1;

        String mergedGroup = new StringBuilder(firstGroup).reverse().append(secondGroup).toString();
        char[] ants = mergedGroup.toCharArray();
        boolean[] check = new boolean[N1+N2];

        for (int i = 0; i < N1; i++)
            check[i] = true;

        while (T-- > 0) {
            for (int i = 0; i < N1 + N2 - 1; i++) {
                if (check[i] && !check[i+1]) {
                    char temp = ants[i];
                    ants[i] = ants[i+1];
                    ants[i+1] = temp;

                    boolean temp2 = check[i];
                    check[i] = check[i+1];
                    check[i+1] = temp2;

                    i++;
                }
            }
        }

        for (char ant : ants)
            bw.write(ant + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
