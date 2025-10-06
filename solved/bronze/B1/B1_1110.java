package solved.bronze.B1;
import java.io.*;

public class B1_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int original = N;
        int current = N;
        int cycle = 0;

        do {
            int tens = current / 10;
            int ones = current % 10;
            int sum = tens + ones;

            current = (ones * 10) + (sum % 10);
            cycle++;
        } while (current != original);
        System.out.println(cycle);
    }
}