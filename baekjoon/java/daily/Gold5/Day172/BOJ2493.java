package Gold5.Day172;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] towers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            towers[i] = Integer.parseInt(st.nextToken());

        String result = receiveLaserSignal(towers);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String receiveLaserSignal(int[] towers) {
        StringBuilder sb = new StringBuilder();

        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < towers.length; i++) {
            int height = towers[i];

            if (stack.isEmpty()) {
                sb.append(0).append(' ');
                stack.push(new Tower(i + 1, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append(0).append(' ');
                        stack.push(new Tower(i + 1, height));
                        break;
                    }

                    Tower tower = stack.peek();

                    if (tower.height > height) {
                        sb.append(tower.index).append(' ');
                        stack.push(new Tower(i + 1, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return sb.toString().trim();
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}