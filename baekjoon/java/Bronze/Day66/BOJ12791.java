package Day66;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12791 {
    public static final int SETTING_PERIOD = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());
        int[][] testCase = new int[Q][SETTING_PERIOD];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SETTING_PERIOD; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            int S = testCase[i][0];
            int E = testCase[i][1];

            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int j = S; j <= E; j++) {
                List<String> albumList = RDBMS.findAlbumsByYear(j);

                if (!albumList.isEmpty()) {
                    cnt += albumList.size();
                    for (String albumName : albumList)
                        sb.append(String.format("%d %s", j, albumName)).append("\n");
                }
            }

            bw.write(cnt + "\n");
            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public enum RDBMS {
        DAVIDBOWIE("DavidBowie", 1967),
        SPACEODDITY("SpaceOddity", 1969),
        THEMANWHOSOLDTHEWORLD("TheManWhoSoldTheWorld", 1970),
        HUNKYDORY("HunkyDory", 1971),
        THERISEANDFALLOFZIGGYSTARDUSTANDTHESPIDERSFROMMARS("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", 1972),
        ALADDINSANE("AladdinSane", 1973),
        PINUPS("PinUps", 1973),
        DIAMONDDOGS("DiamondDogs", 1974),
        YOUNGAMERICANS("YoungAmericans", 1975),
        STATIONTOSTATION("StationToStation", 1976),
        LOW("Low", 1977),
        HEROES("Heroes", 1977),
        LODGER("Lodger", 1979),
        SCARYMONSTERSANDSUPERCREEPS("ScaryMonstersAndSuperCreeps", 1980),
        LETSDANCE("LetsDance", 1983),
        TONIGHT("Tonight", 1984),
        NEVERLETMEDOWN("NeverLetMeDown", 1987),
        BLACKTIEWHITENOISE("BlackTieWhiteNoise", 1993),
        OUTSIDE("1.Outside", 1995),
        EARTHLING("Earthling", 1997),
        HOURS("Hours", 1999),
        HEATHEN("Heathen", 2002),
        REALITY("Reality", 2003),
        THENEXTDAY("TheNextDay", 2013),
        BLACKSTAR("BlackStar", 2016);

        private final String albumName;
        private final int yearOfRelease;
        RDBMS (String  albumName, int yearOfRelease) {
            this.albumName = albumName;
            this. yearOfRelease = yearOfRelease;
        }

        public static List<String> findAlbumsByYear (int year) {
            List<String> albumList = new ArrayList<>();
            for (RDBMS album : RDBMS.values()) {
                if (album.yearOfRelease == year)
                    albumList.add(album.albumName);
            }
            return albumList;
        }
    }
}
