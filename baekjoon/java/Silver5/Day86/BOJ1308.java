package Silver5.Day86;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class BOJ1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] todayInfo = new int[3];
        for (int i = 0 ; i < todayInfo.length; i++)
            todayInfo[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] dDayInfo = new int[3];
        for (int i = 0 ; i < dDayInfo.length; i++)
            dDayInfo[i] = Integer.parseInt(st.nextToken());

        LocalDate today = LocalDate.of(todayInfo[0], todayInfo[1], todayInfo[2]);
        LocalDate dDay = LocalDate.of(dDayInfo[0], dDayInfo[1], dDayInfo[2]);

        if (!dDay.minusYears(1000).isBefore(today)) {
            bw.write("gg");
        } else {
            long daysBetween = ChronoUnit.DAYS.between(today, dDay);
            bw.write(String.format("D-%d", daysBetween));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
