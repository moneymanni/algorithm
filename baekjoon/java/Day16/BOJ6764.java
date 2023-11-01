package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] depth = new int[4];
        for (int i = 0; i < 4; i++)
            depth[i] = Integer.parseInt(br.readLine());

        if (depth[0] > depth[1] && depth[1] > depth[2] && depth[2] > depth[3]) {
            System.out.println("Fish Diving");
        } else if (depth[3] > depth[2] && depth[2] > depth[1] && depth[1] > depth[0]) {
            System.out.println("Fish Rising");
        } else if (depth[0] == depth[1] && depth[0] == depth[2] && depth[0] == depth[3]) {
            System.out.println("Fish At Constant Depth");
        } else {
            System.out.println("No Fish");
        }

        br.close();
    }
}
