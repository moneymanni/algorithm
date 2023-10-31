package Day15;

import java.io.*;

public class BOJ6763 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int speedLimit = Integer.parseInt(br.readLine());
        int speedOfCar = Integer.parseInt(br.readLine());

        int d = speedOfCar - speedLimit;

        if (d <= 0)
            bw.write("Congratulations, you are within the speed limit!");
        else if (d <= 20)
            bw.write("You are speeding and your fine is $" + 100 + ".");
        else if (d <= 30)
            bw.write("You are speeding and your fine is $" + 270 + ".");
        else
            bw.write("You are speeding and your fine is $" + 500 + ".");

        br.close();
        bw.close();
    }
}
