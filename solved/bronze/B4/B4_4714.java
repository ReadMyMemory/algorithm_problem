package solved.bronze.B4;
import java.io.*;
public class B4_4714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            double weight = Double.parseDouble(br.readLine());
            if (weight < 0) {
                break;
            }

            double moonWeight = weight * 0.167;
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.%n", weight, moonWeight);
        }

    }
}
