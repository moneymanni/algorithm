package Gold5.Day173;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        GearCollection gearSet = new GearCollection(4);

        for (int i = 0; i < gearSet.gears.length; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                int num = input.charAt(j) - '0';

                gearSet.gears[i].setTeeth(j, num);
            }
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            gearSet.rotate(idx, dir);
        }

        int result = gearSet.getScore();

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }
}

class GearCollection {
    int num;
    Gear[] gears;

    public GearCollection(int num) {
        this.num = num;
        gears = new Gear[num];

        for (int i = 0; i < num; i++)
            gears[i] = new Gear();
    }

    public void rotate(int idx, int dir) {
        int[] dirs = new int[num];
        dirs[idx] = dir;

        for (int i = idx; i > 0; i--) {
            if (gears[i].get9OClockDir() != gears[i - 1].get3OClockDir())
                dirs[i - 1] = -dirs[i];
            else
                break;
        }

        for (int i = idx; i < num - 1; i++) {
            if (gears[i].get3OClockDir() != gears[i + 1].get9OClockDir())
                dirs[i + 1] = -dirs[i];
            else
                break;
        }

        for (int i = 0; i < num; i++) {
            if (dirs[i] != 0)
                gears[i].turns(dirs[i]);
        }
    }

    public int getScore() {
        int sum = 0;

        for (int i = 0; i < num; i++)
            sum += gears[i].get12OClockDir() * (1 << i);

        return sum;
    }
}

class Gear {
    int index;
    int[] teeth;

    public Gear() {
        index = 0;
        teeth = new int[8];
    }

    public void setTeeth(int index, int num) {
        teeth[index] = num;
    }

    public void turns(int dir) {
        if (dir == -1)
            index = (index + 1) % 8;
        else
            index = (index - 1 + 8) % 8;
    }

    public int get3OClockDir() {
        return teeth[(index + 2) % 8];
    }

    public int get9OClockDir() {
        return teeth[(index + 6) % 8];
    }

    public int get12OClockDir() {
        return teeth[index];
    }
}
