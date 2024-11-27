package Silver3.Day125;

import java.io.*;

public class BOJ2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();

            TurtleRobot turtle = new TurtleRobot(0, 0);

            for (int i = 0; i < commands.length(); i++)
                turtle.execute(commands.charAt(i));

            int result = turtle.getMaxHeight() * turtle.getMaxWidth();
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class TurtleRobot {
        int nx, ny;
        private final int[] dx = new int[]{0, 1, 0,-1};
        private final int[] dy = new int[]{1, 0, -1, 0};
        private int idx = 0;
        private int[] tx = new int[]{0, 0};
        private int[] ty = new int[]{0, 0};

        TurtleRobot(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }

        public void execute(char command) {
            switch (command) {
                case 'L':
                    idx = (idx + 3) % 4;
                    return;
                case 'R':
                    idx = (idx + 1) % 4;
                    return;
                case 'F':
                    nx += dx[idx];
                    ny += dy[idx];
                    break;
                case 'B':
                    nx -= dx[idx];
                    ny -= dy[idx];
                    break;
            }

            tx[0] = Math.min(tx[0], nx);
            tx[1] = Math.max(tx[1], nx);
            ty[0] = Math.min(ty[0], ny);
            ty[1] = Math.max(ty[1], ny);
        }

        public int getMaxHeight() {
            return ty[1] - ty[0];
        }

        public int getMaxWidth() {
            return tx[1] - tx[0];
        }
    }
}
