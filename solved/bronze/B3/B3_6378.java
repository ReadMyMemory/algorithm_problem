package solved.bronze.B3;
import java.io.*;

public class B3_6378 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            sb.append(getDigitalRoot(input)).append("\n");
        }

        System.out.print(sb);
    }

    private static int getDigitalRoot(String num) {
        while (num.length() > 1) {
            int sum = 0;
            for (char c : num.toCharArray()) {
                sum += c - '0';
            }
            num = String.valueOf(sum);
        }
        return Integer.parseInt(num);
    }
}
