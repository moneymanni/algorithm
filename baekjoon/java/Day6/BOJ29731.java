package Day6;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ29731 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());

        String result = "No";
        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Promise promise = Promise.of(str);
            if (promise == null) {
                result = "Yes";
                break;
            }
        }
        System.out.println(result);
    }
}

enum Promise {
    FIRST("Never gonna give you up"),
    SECOND("Never gonna let you down"),
    THIRD("Never gonna run around and desert you"),
    FOURTH("Never gonna make you cry"),
    FIFTH("Never gonna say goodbye"),
    SIXTH("Never gonna tell a lie and hurt you"),
    SEVENTH("Never gonna stop");

    private final String promise;
    Promise(String promise) {
        this.promise = promise;
    }
    public String getPromise() {
        return promise;
    }

    private static final Map<String, String> PROMISE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Promise::getPromise, Promise::name)));
    public static Promise of(final String promise) {
        try {
            return Promise.valueOf(PROMISE_MAP.get(promise));
        } catch (NullPointerException e) {
            return null;
        }
    }
}