package solved.silver.S5;
import java.io.*;
import java.math.BigInteger;

public class S5_6463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());
            sb.append(String.format("%5d -> %d\n", n, lastNonZeroDigit(n)));
        }

        System.out.print(sb);
    }

    private static int lastNonZeroDigit(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            int num = i;

            // 2와 5를 제거하여 10의 배수를 없앰
            while (num % 10 == 0) {
                num /= 10;
            }

            result *= num;

            // 0을 방지하기 위해 마지막 자리를 유지
            while (result % 10 == 0) {
                result /= 10;
            }
            result %= 100000; // 큰 수 방지를 위해 자릿수를 제한
        }

        return result % 10;
    }
}
