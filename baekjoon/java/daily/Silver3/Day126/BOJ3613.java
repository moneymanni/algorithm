package Silver3.Day126;

import java.io.*;

public class BOJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String variableName = br.readLine();

        if (isJavaStyle(variableName))
            bw.write(javaToCpp(variableName));
        else if (isCppStyle(variableName))
            bw.write(cppToJava(variableName));
        else
            bw.write("Error!");

        br.close();
        bw.flush();
        bw.close();
    }

    private static String javaToCpp(String identifier) {
        StringBuilder sb = new StringBuilder();

        for (char ch : identifier.toCharArray()) {
            if (Character.isUpperCase(ch))
                sb.append('_').append(Character.toLowerCase(ch));
            else
                sb.append(ch);
        }

        return sb.toString();
    }

    private static String cppToJava(String identifier) {
        StringBuilder sb = new StringBuilder();
        boolean nextUpper = false;

        for (char ch : identifier.toCharArray()) {
            if (ch == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    sb.append(Character.toUpperCase(ch));
                    nextUpper = false;
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    private static boolean isJavaStyle(String identifier) {
        return identifier.matches("[a-z][a-zA-Z]*");
    }

    private static boolean isCppStyle(String identifier) {
        return identifier.matches("[a-z][a-z0-9]*(_[a-z0-9]+)*");
    }
}
