package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_1816 {
    static final int LIMIT = 1_000_000;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //10^6 이하의 소수를 구한다.
        sieve();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long S = Long.parseLong(br.readLine());
            sb.append(isValidKey(S) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static void sieve() {
        boolean[] isPrime = new boolean[LIMIT + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= LIMIT; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static boolean isValidKey(long S) {
        for (int prime : primes) {
            if (prime > Math.sqrt(S)) break; // 소인수 찾기 종료 조건
            if (S % prime == 0) return false; // 10^6 이하의 소인수가 있으면 NO
        }
        return true;
    }
}
