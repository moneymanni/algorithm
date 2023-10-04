package Day4;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BOJ16170 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));

        System.out.printf("%d\n%d\n%d\n", zonedDateTime.getYear(), zonedDateTime.getMonthValue(), zonedDateTime.getDayOfMonth());
    }
}
