package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ10869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        Operations op = new Operations(A, B);

        System.out.println(op.add());
        System.out.println(op.minus());
        System.out.println(op.multiply());
        System.out.println(op.divide());
        System.out.println(op.remainder());
    }

    private static class Operations {
        private int a;
        private int b;

        public Operations(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int add() {
            return a + b;
        }

        public int minus() {
            return a - b;
        }

        public int multiply() {
            return a * b;
        }

        public int divide() {
            return a / b;
        }

        public int remainder() {
            return a % b;
        }
    }
}
