package solved.bronze.B1;
import java.io.*;

public class B1_10701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long ans = 1;

        // 2 처리
        int exp = 0;
        while (n % 2 == 0) {
            n /= 2;
            exp++;
        }
        if (exp > 0) ans *= (exp + 1);

        // 홀수 소수 처리 (3,5,7,...)
        for (long p = 3; p * p <= n; p += 2) {
            exp = 0;
            while (n % p == 0) {
                n /= p;
                exp++;
            }
            if (exp > 0) ans *= (exp + 1);
        }

        // 남은 n이 1보다 크면 소수 1개가 남은 거임(지수 1)
        if (n > 1) ans *= 2;

        System.out.println(ans);
    }
}