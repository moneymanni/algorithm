package Day2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2754 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String grade = st.nextToken().strip();

            switch (grade) {
                case "A+":
                    System.out.println(4.3);
                    break;
                case "A0":
                    System.out.println(4.0);
                    break;
                case "A-":
                    System.out.println(3.7);
                    break;
                case "B+":
                    System.out.println(3.3);
                    break;
                case "B0":
                    System.out.println(3.0);
                    break;
                case "B-":
                    System.out.println(2.7);
                    break;
                case "C+":
                    System.out.println(2.3);
                    break;
                case "C0":
                    System.out.println(2.0);
                    break;
                case "C-":
                    System.out.println(1.7);
                    break;
                case "D+":
                    System.out.println(1.3);
                    break;
                case "D0":
                    System.out.println(1.0);
                    break;
                case "D-":
                    System.out.println(0.7);
                    break;
                case "F":
                    System.out.println(0.0);
                    break;
                default:
                    System.out.println("Invalid grade");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 신기하게 풀어서 가져와 봄 ㅋㅋㅋ
//public class Main{
//    public static void main(String[] aa) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String answer = br.readLine();
//        answer = answer.replace("A+","4.3");
//        answer = answer.replace("A0","4.0");
//        answer = answer.replace("A-","3.7");
//        answer = answer.replace("B+","3.3");
//        answer = answer.replace("B0","3.0");
//        answer = answer.replace("B-","2.7");
//        answer = answer.replace("C+","2.3");
//        answer = answer.replace("C0","2.0");
//        answer = answer.replace("C-","1.7");
//        answer = answer.replace("D+","1.3");
//        answer = answer.replace("D0","1.0");
//        answer = answer.replace("D-","0.7");
//        answer = answer.replace("F","0.0");
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write(answer);
//        br.close();
//        bw.close();
//    }
//}
