package Day63;

import java.io.*;

public class BOJ2596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfChars = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String[] nums = new String[numOfChars];
        for (int i = 0; i < numOfChars; i++)
            nums[i] = str.substring(i * 6, (i + 1) * 6);

        StringBuilder sb = new StringBuilder();
        boolean isUnknown = false;
        int idx = 0;
        for (int i = 0; i < numOfChars; i++) {
            try {
                sb.append(SecretLetter.fromValue(nums[i]));
            } catch (IllegalArgumentException e) {
                isUnknown = true;
                idx = i + 1;
                break;
            }
        }

        if (!isUnknown)
            bw.write(sb.toString());
        else
            bw.write(idx + "");

        br.close();
        bw.flush();
        bw.close();
    }
    public enum SecretLetter {
        A("000000"), B("001111"), C("010011"),
        D("011100"), E("100110"), F("101001"),
        G("110101"), H("111010");

        private final String value;

        SecretLetter(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static SecretLetter fromValue(String value) {
            for (SecretLetter letter : SecretLetter.values()) {
                if (isOneBitDifference(letter.getValue(), value)) {
                    return letter;
                }
            }
            throw new IllegalArgumentException("Unknown value: " + value);
        }

        private static boolean isOneBitDifference(String a, String b) {
            int diffCount = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                }
            }
            return diffCount == 1 || diffCount == 0;
        }
    }
}
