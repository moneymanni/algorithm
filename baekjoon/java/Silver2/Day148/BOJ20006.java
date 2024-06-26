package Silver2.Day148;

import java.io.*;
import java.util.*;

public class BOJ20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            Player player = new Player(n, l);

            boolean matched = false;

            for (Room room : rooms) {
                if (room.canEnter(player)) {
                    room.addPlayer(player);
                    matched = true;
                    break;
                }
            }

            if (!matched)
                rooms.add(new Room(player, m));
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms)
            sb.append(room.startGame()).append('\n');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    static class Room {
        List<Player> players;
        int maxSize;
        int baseLavel;

        public Room(Player firstPlayer, int maxSize) {
            this.players = new ArrayList<>();
            this.maxSize = maxSize;
            this.baseLavel = firstPlayer.level;
            this.players.add(firstPlayer);
        }

        public boolean canEnter(Player player) {
            return players.size() < maxSize && Math.abs(player.level - baseLavel) <= 10;
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public String startGame() {
            StringBuilder sb = new StringBuilder();
            if (players.size() == maxSize) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            Collections.sort(players, Comparator.comparing(player -> player.nickname));

            for (Player player : players)
                sb.append(player.level).append(' ').append(player.nickname).append('\n');

            return sb.toString().trim();
        }
    }

    static class Player {
        String nickname;
        int level;

        public Player(String nickname, int level) {
            this.nickname = nickname;
            this.level = level;
        }
    }
}
