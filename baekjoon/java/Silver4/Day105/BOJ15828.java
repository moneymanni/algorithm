package Silver4.Day105;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int input;
        while ((input = Integer.parseInt(br.readLine())) != -1) {
            if (input == 0)
                queue.poll();
            else if (queue.size() < N)
                queue.offer(input);
        }

        if (queue.isEmpty())
            bw.write("empty");
        else
            for (Integer num : queue)
                bw.write(num + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
