package Gold5.Day178;

import java.io.*;
import java.util.*;

public class BOJ21608 {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N;
    private static int sum;
    private static int[] students;
    private static int[][] map;
    private static Map<Integer, Set<Integer>> preferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        sum = 0;
        map = new int[N][N];
        students = new int[N * N];
        preferences = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            students[i] = student;
            preferences.put(student, new HashSet<>());

            for (int j = 0; j < 4; j++)
                preferences.get(student).add(Integer.parseInt(st.nextToken()));
        }

        solve();

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void solve() {
        for (int i = 0; i < students.length; i++) {
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = getStudentSum(i, j, map[i][j]);

                if (cnt > 0)
                    sum += (int) Math.pow(10, cnt - 1);
            }
        }
    }

    private static Seat findSeat(int studentId) {
        Seat seat = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0)
                    continue;

                Seat currSeat = new Seat(i, j, getStudentSum(i, j, studentId), getEmptySum(i, j));

                if (seat == null || seat.compareTo(currSeat) > 0)
                    seat = currSeat;
            }
        }

        return seat;
    }

    private static int getStudentSum(int x, int y, int studentId) {
        int cnt = 0;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (preferences.get(studentId).contains(map[nx][ny]))
                cnt++;
        }

        return  cnt;
    }

    private static int getEmptySum(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (map[nx][ny] == 0)
                cnt++;
        }

        return  cnt;
    }

    static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int studentSum;
        int emptySum;

        public Seat(int x, int y, int studentSum, int emptySum) {
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        @Override
        public int compareTo(Seat obj) {
            if (studentSum != obj.studentSum)
                return -(studentSum - obj.studentSum);
            else if (emptySum != obj.emptySum)
                return -(emptySum - obj.emptySum);
            else if (x != obj.x)
                return x - obj.x;
            return y - obj.y;
        }
    }
}
