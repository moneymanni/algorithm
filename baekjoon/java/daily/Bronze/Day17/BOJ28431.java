package Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ28431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> socks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            if (socks.isEmpty()) {
                socks.add(num);
                continue;
            }
            if (socks.contains(num))
                socks.remove(Integer.valueOf(num));
            else
                socks.add(num);
        }
        for (int sock : socks)
            System.out.println(sock);

        br.close();
    }
}
