package solved.bronze.B2;
import java.io.*;

public class B2_2581 {
    // n이 소수면 true
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        // 3부터 sqrt(n)까지 홀수만 검사
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());

        int sum = 0;
        int minPrime = -1;

        for (int x = M; x <= N; x++) {
            if (isPrime(x)) {
                sum += x;
                if (minPrime == -1) minPrime = x;
            }
        }

        if (minPrime == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minPrime);
        }
    }
}
