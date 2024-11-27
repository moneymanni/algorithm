package Gold5.Day176;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int size = N * 2;

        ConveyorBelt conveyorBelt = new ConveyorBelt(size);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++)
            conveyorBelt.buildBelt(i, Integer.parseInt(st.nextToken()));

        int result = conveyorBelt.operate(K);

        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static class ConveyorBelt {
        int step;
        int size;
        int halfSize;
        int zeroDurabilityCount;
        LinkedList<Slot> conveyorBelt;
        public ConveyorBelt(int size) {
            this.size = size;
            this.halfSize = size / 2;
            this.step = 0;
            this.conveyorBelt = new LinkedList<>();
        }

        public void buildBelt(int index, int durability) {
            conveyorBelt.add(index, new Slot(durability));
        }

        public int operate(int zeroLimitNum) {
            while (zeroDurabilityCount < zeroLimitNum) {
                moveConveyorBelt();
                moveRobot();
                placeRobot();
            }

            return step;
        }

        public void moveConveyorBelt() {
            step++;
            conveyorBelt.add(0, conveyorBelt.removeLast());

            if (conveyorBelt.get(halfSize - 1).isRobot)
                conveyorBelt.get(halfSize - 1).isRobot = false;
        }

        public void moveRobot() {
            for (int i = halfSize - 1; i > 0; i--) {
                if (!conveyorBelt.get(i).isRobot
                        || conveyorBelt.get(i + 1).isRobot
                        || conveyorBelt.get(i + 1).durability <= 0)
                    continue;

                conveyorBelt.get(i).isRobot = false;
                conveyorBelt.get(i + 1).putRobot();

                if (conveyorBelt.get(i + 1).durability <= 0)
                    zeroDurabilityCount++;

                if (i + 1 == halfSize - 1)
                    conveyorBelt.get(i + 1).isRobot = false;
            }
        }

        public void placeRobot() {
            if (conveyorBelt.get(0).durability > 0) {
                conveyorBelt.get(0).putRobot();

                if (conveyorBelt.get(0).durability == 0)
                    zeroDurabilityCount++;
            }
        }
    }

    static class Slot {
        int durability;
        boolean isRobot;

        public Slot(int durability) {
            this.durability = durability;
            isRobot = false;
        }

        public void putRobot() {
            isRobot = true;
            durability--;
        }
    }
}
