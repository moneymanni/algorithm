package Silver2.Day146;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Train[] trains = new Train[N + 1];

        for (int i = 1; i <= N; i++)
            trains[i] = new Train();

        while (M-- > 0) {
            String input = br.readLine();

            st = new StringTokenizer(input);

            int option = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (option == 1 || option == 2) {
                int x = Integer.parseInt(st.nextToken());
                trains[i].run(option, x);
            } else if (option == 3 || option == 4) {
                trains[i].run(option);
            }
        }

        HashSet<Train> set = new HashSet<>();

        for (int i = 1; i <= N; i++)
            set.add(trains[i]);

        bw.write(set.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Train  {
        public int seat;

        public Train() {
            seat = 0;
        }

        public void run(int option, int x) {
            switch (option) {
                case 1:
                    seat |= (1 << x);
                    break;
                case 2:
                    seat &= ~(1 << x);
                    break;
            }
        }

        public void run(int option) {
            switch (option) {
                case 3:
                    seat <<= 1;
                    seat &= ((1 << 21) - 1);
                    break;
                case 4:
                    seat >>= 1;
                    seat &= ~1;
                    break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Train train = (Train) obj;
            return seat == train.seat;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(seat);
        }
    }

//    static class Train  {
//        public boolean[] seat;
//
//        public Train() {
//            seat = new boolean[21];
//        }
//
//        public void run(int option, int x) {
//            switch (option) {
//                case 1:
//                    seat[x] = true;
//                    break;
//                case 2:
//                    seat[x] = false;
//                    break;
//            }
//        }
//
//        public void run(int option) {
//            switch (option) {
//                case 3:
//                    for (int i = seat.length - 1; i > 1; i--)
//                        seat[i] = seat[i - 1];
//                    seat[1] = false;
//                    break;
//                case 4:
//                    for (int i = 1; i < seat.length - 1; i++)
//                        seat[i] = seat[i + 1];
//                    seat[seat.length - 1] = false;
//                    break;
//            }
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) return true;
//            if (obj == null || getClass() != obj.getClass()) return false;
//            Train train = (Train) obj;
//            return Arrays.equals(seat, train.seat);
//        }
//
//        @Override
//        public int hashCode() {
//            return Arrays.hashCode(seat);
//        }
//    }
}
