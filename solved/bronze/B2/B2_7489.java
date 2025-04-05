package solved.bronze.B2;
import java.io.*;
import java.math.BigInteger;

public class B2_7489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(findRightmostNonZeroDigit(n));
        }
    }

    // 최우측 0이 아닌 숫자를 찾는 함수
    public static int findRightmostNonZeroDigit(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String factStr = factorial.toString();

        // 뒤에서부터 0이 아닌 숫자를 찾음
        for (int i = factStr.length() - 1; i >= 0; i--) {
            char ch = factStr.charAt(i);
            if (ch != '0') {
                return ch - '0';
            }
        }

        return -1; // 일반적으로 도달하지 않음
    }
}
