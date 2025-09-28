package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_4969 {
    static boolean[] isPrime;
    static boolean[] isMSPrime;
    static final int MAX = 300001;

    // 월요일-토요일 숫자인지 확인
    static boolean isMS(int n) {
        int r = n % 7;
        return r == 1 || r == 6;
    }

    // 에라토스테네스의 체로 소수 구하기
    static void sieve() {
        isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // 월요일-토요일 소수 구하기
    static void findMSPrimes() {
        isMSPrime = new boolean[MAX];

        for (int i = 2; i < MAX; i++) {
            if (!isMS(i)) continue;

            boolean prime = true;
            // i의 월요일-토요일 약수 찾기
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0 && isMS(j) && isMS(i / j)) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                isMSPrime[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieve();
        findMSPrimes();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) break;

            Set<Integer> factors = new TreeSet<>();

            // n의 모든 약수 찾기
            for (int i = 2; i <= n; i++) {
                if (n % i == 0 && isMS(i) && isMS(n / i) && isMSPrime[i]) {
                    factors.add(i);
                }
            }

            sb.append(n).append(":");
            if (factors.isEmpty()) {
                sb.append(" ").append(n);
            } else {
                for (int f : factors) {
                    sb.append(" ").append(f);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}