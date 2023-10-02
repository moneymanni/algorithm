package Day7;

import java.io.*;

public class BOJ5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int hamburger = Integer.parseInt(br.readLine().strip());
        for (int i = 0; i < 2; i++)
            hamburger = Math.min(hamburger, Integer.parseInt(br.readLine().strip()));
        int drink = Math.min(Integer.parseInt(br.readLine().strip()), Integer.parseInt(br.readLine().strip()));

        bw.write(String.valueOf(hamburger + drink - 50));
        bw.close();
    }
}
