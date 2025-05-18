package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_15965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 8,000,000까지 검사
        int limit = 8000000;
        boolean[] isNotPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                if (primes.size() == K) {
                    System.out.println(i);
                    return;
                }
                for (long j = (long) i * i; j <= limit; j += i) {
                    isNotPrime[(int) j] = true;
                }
            }
        }
    }
}
