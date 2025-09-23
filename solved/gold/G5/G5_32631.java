package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_32631 {
    static int N, K;
    static long[] sumA, sumB;

    // target 이하로 만들 수 있는지 확인
    static boolean canMake(long target) {
        for (int ka = 0; ka <= Math.min(K, N); ka++) {
            int kb = K - ka;
            if (kb > N) continue;

            // A에서 ka개 제거시 target 이하 가능한지
            boolean canA = false;
            for (int i = 0; i <= ka; i++) {
                if (sumA[N - (ka - i)] - sumA[i] <= target) {
                    canA = true;
                    break;
                }
            }

            // B에서 kb개 제거시 target 이하 가능한지
            boolean canB = false;
            for (int i = 0; i <= kb; i++) {
                if (sumB[N - (kb - i)] - sumB[i] <= target) {
                    canB = true;
                    break;
                }
            }

            // 둘 다 target 이하로 만들 수 있으면 가능
            if (canA && canB) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sumA = new long[N + 1];
        sumB = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sumA[i + 1] = sumA[i] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sumB[i + 1] = sumB[i] + Integer.parseInt(st.nextToken());
        }

        // 이진 탐색으로 답 찾기
        long left = 0;
        long right = Math.max(sumA[N], sumB[N]);
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canMake(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}