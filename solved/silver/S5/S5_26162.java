package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_26162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 원자 번호 개수
        int N = Integer.parseInt(br.readLine());

        // 소수 목록 미리 구해두기 (1~118 범위)
        boolean[] isPrime = sieve(118);

        // 입력받은 각 원자 번호에 대해 처리
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (canBeSumOfTwoPrimes(a, isPrime)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    // 에라토스테네스의 체로 소수 구하기
    public static boolean[] sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // 주어진 수 a가 두 소수의 합으로 표현 가능한지 확인
    public static boolean canBeSumOfTwoPrimes(int a, boolean[] isPrime) {
        for (int i = 2; i <= a / 2; i++) {
            if (isPrime[i] && isPrime[a - i]) {
                return true;
            }
        }
        return false;
    }
}
