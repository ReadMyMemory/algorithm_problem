package solved.bronze.B4;
import java.io.*;

public class B4_5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        System.out.println(totalPrice - sum);
    }
}
