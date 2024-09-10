package Silver1.Day168;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ3107 {
    private static final String GROUPING = "grouping";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String output = restoreIPv6(input);

        bw.write(output);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String restoreIPv6(String input) {
        if (input.contains("::"))
            input = input.replace("::", ":" + GROUPING + ":");

        List<String> arr = Stream.of(input.split(":")).collect(Collectors.toList());
        List<String> IPv6 = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);

            if (str.isEmpty())
                continue;
            else if (!str.equals(GROUPING))
                str = "0".repeat(4 - str.length()) + str;

            IPv6.add(str);
        }

        String[] fullIp = new String[8];
        int groupLen = 8 - IPv6.size() + 1;
        int idx = 0;

        for (String address : IPv6) {
            if (address.equals(GROUPING))
                while (groupLen-- > 0) fullIp[idx++] = "0000";
            else
                fullIp[idx++] = address;
        }

        return String.join(":", fullIp);
    }
}
