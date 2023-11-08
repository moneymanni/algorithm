package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[2];
        num[0] = Integer.parseInt(st.nextToken());
        num[1] = Integer.parseInt(st.nextToken());

        while(num[0] != 0 || num[1] != 0) {
            if (num[0] % num[1] == 0)
                System.out.println("multiple");
            else if (num[1] % num[0] == 0)
                System.out.println("factor");
            else
                System.out.println("neither");

            st = new StringTokenizer(br.readLine());
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
