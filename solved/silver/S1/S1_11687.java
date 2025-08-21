package solved.silver.S1;
import java.io.*;

public class S1_11687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        // M이 존재할 수 없는 경우를 체크
        // 5의 배수가 아닌 수는 trailing zero 개수로 나올 수 없음
        if (!isPossible(M)) {
            System.out.println(-1);
            return;
        }

        // 이분 탐색으로 가장 작은 N 찾기
        long left = 0;
        long right = 5L * M; // 대략적인 상한
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long zeros = countTrailingZeros(mid);

            if (zeros < M) {
                left = mid + 1;
            } else if (zeros > M) {
                right = mid - 1;
            } else {
                answer = mid;
                right = mid - 1; // 더 작은 값이 있는지 확인
            }
        }

        System.out.println(answer);
    }

    // N!의 끝에 있는 0의 개수를 계산
    private static long countTrailingZeros(long n) {
        long count = 0;
        long divisor = 5;

        while (divisor <= n) {
            count += n / divisor;
            divisor *= 5;
        }

        return count;
    }

    // M개의 trailing zero가 가능한지 확인
    private static boolean isPossible(int M) {
        // 5, 10, 15, 20까지는 1개
        // 25, 30, 35, 40, 45까지는 6개
        // 50, 55, 60, 65, 70까지는 12개
        // ...
        // 5의 거듭제곱마다 추가로 0이 생김

        // 이분 탐색으로 정확히 M개의 0을 만드는 N이 있는지 확인
        long left = 0;
        long right = 5L * M;

        while (left <= right) {
            long mid = (left + right) / 2;
            long zeros = countTrailingZeros(mid);

            if (zeros < M) {
                left = mid + 1;
            } else if (zeros > M) {
                right = mid - 1;
            } else {
                return true; // 정확히 M개를 만드는 수가 존재
            }
        }

        return false;
    }
}