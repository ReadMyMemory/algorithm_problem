package solved.bronze.B2;
import java.io.*;

public class B2_4564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("0")) break;

            int num = Integer.parseInt(line);
            sb.append(num);

            while (num >= 10) {
                num = multiplyDigits(num);
                sb.append(" ").append(num);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int multiplyDigits(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}
