package Day43;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[][] testCase = new String[T][2];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = st.nextToken();
        }

        for (int i = 0; i < testCase.length; i++) {
            char[] x = testCase[i][0].toCharArray();
            char[] y = testCase[i][1].toCharArray();

            bw.write("Distances: ");
            for (int j = 0; j < x.length; j++) {
                int numX = x[j] - 'A' + 1;
                int numY = y[j] - 'A' + 1;

                int result = numY >= numX ? numY - numX : (numY + 26) - numX;
                bw.write(result + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class BOJ5218 {
//    private static ArrayList<Integer> solveAlphabetDistance(String s1, String s2) {
//
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//
//        /* ------------------- INSERT CODE HERE ---------------------*/
//
//        // answer.add(x);	// add x to ArrayList<Integer> answer
//
//        char[] x = s1.toCharArray();
//        char[] y = s2.toCharArray();
//
//        for (int j = 0; j < x.length; j++) {
//            int numX = x[j] - 'A' + 1;
//            int numY = y[j] - 'A' + 1;
//
//            int result = numY >= numX ? numY - numX : (numY + 26) - numX;
//            answer.add(result);
//        }
//
//        /* -------------------- END OF INSERTION --------------------*/
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int numCases = sc.nextInt();
//
//        for(int i = 0; i < numCases; i++)
//        {
//            String s1 = sc.next();
//            String s2 = sc.next();
//
//            ArrayList<Integer> answer = solveAlphabetDistance(s1, s2);
//            System.out.print("Distances: ");
//
//            for(Integer d : answer) {
//                System.out.print(d+" ");
//            }
//            System.out.println();
//
//        }
//    }
//}
