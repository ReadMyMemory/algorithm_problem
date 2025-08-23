package solved.gold;
import java.io.*;
import java.util.*;

public class G3_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N이 1이면 소수가 아니므로 0 출력
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 에라토스테네스의 체로 N까지의 소수 구하기
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수들을 리스트에 저장
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 투 포인터로 연속된 소수의 합 찾기
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            // 합이 N보다 크거나 같으면 왼쪽 포인터 이동
            if (sum >= N) {
                if (sum == N) {
                    count++;
                }
                if (left >= primes.size()) break;
                sum -= primes.get(left);
                left++;
            }
            // 합이 N보다 작으면 오른쪽 포인터 이동
            else {
                if (right >= primes.size()) break;
                sum += primes.get(right);
                right++;
            }
        }
        System.out.println(count);
    }
}