package solved.bronze.B4;
import java.io.*;
public class B4_6763 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int speedLimit = Integer.parseInt(br.readLine());
        int recordedSpeed = Integer.parseInt(br.readLine());

        int overSpeed = recordedSpeed - speedLimit;

        if (overSpeed <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else {
            int fine;
            if (overSpeed >= 1 && overSpeed <= 20) {
                fine = 100;
            } else if (overSpeed >= 21 && overSpeed <= 30) {
                fine = 270;
            } else {
                fine = 500;
            }
            System.out.println("You are speeding and your fine is $" + fine + ".");
        }
    }
}
