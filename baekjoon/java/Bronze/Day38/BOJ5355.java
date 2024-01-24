package Day38;

import java.io.*;
import java.util.Stack;

public class BOJ5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] testCase = new String[T];
        for (int i = 0; i < T; i++)
            testCase[i] = br.readLine();

        for (int i = 0; i < T; i++) {
            String[] marsMathFormula = testCase[i].split(" ");

            double result = Double.parseDouble(marsMathFormula[0]);
            for (int j = 1; j < marsMathFormula.length; j++) {
                char operator = marsMathFormula[j].charAt(0);
                switch (operator) {
                    case '@':
                        result *= 3;
                        break;
                    case '%':
                        result += 5;
                        break;
                    case '#':
                        result -= 7;
                        break;
                }
            }
            bw.write(String.format("%.2f\n", result));

//            StringBuilder sb = new StringBuilder(marsMathFormula[0]);
//
//            // 계산식 문자열로 만들기
//            for (int j = 1; j < marsMathFormula.length; j++) {
//                char operator = marsMathFormula[j].charAt(0);
//                switch (operator) {
//                    case '@':
//                        sb.append(" * ").append(3);
//                        break;
//                    case '%':
//                        sb.append(" + ").append(5);
//                        break;
//                    case '#':
//                        sb.append(" - ").append(7);
//                        break;
//                }
//            }
//
//            // 스택을 이용하여 계산하기
//            Stack<String> stack = new Stack<>();
//            String[] earthMathFormula = sb.toString().split(" ");
//            stack.push(earthMathFormula[0]);
//            for (int j = 1; j < earthMathFormula.length; j += 2) {
//                double num;
//                switch (earthMathFormula[j]) {
//                    case "+":
//                        stack.push("+");
//                        stack.push(earthMathFormula[j+1]);
//                        break;
//                    case "-":
//                        stack.push("-");
//                        stack.push(earthMathFormula[j+1]);
//                        break;
//                    case "*":
//                        num = Double.parseDouble(stack.pop());
//                        num *= Double.parseDouble(earthMathFormula[j+1]);
//                        stack.push(String.valueOf(num));
//                        break;
//                    case "/":
//                        num = Double.parseDouble(stack.pop());
//                        num /= Double.parseDouble(earthMathFormula[j+1]);
//                        stack.push(String.valueOf(num));
//                        break;
//                }
//            }
//
//            double result = Double.parseDouble(stack.pop());
//            while (!stack.empty()) {
//                String operator = stack.pop();
//                switch (operator) {
//                    case "+":
//                        result = Double.parseDouble(stack.pop()) + result;
//                        break;
//                    case "-":
//                        result = Double.parseDouble(stack.pop()) - result;
//                        break;
//                }
//            }
//
//            bw.write(String.format("%.2f\n", result));
        }

        br.close();
        bw.close();
    }
}
