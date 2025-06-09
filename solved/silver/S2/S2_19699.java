package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_19699 {
    static int N, M;
    static int[] cows;
    static Set<Integer> primeSums = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cows = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        // 조합
        combine(0, 0, 0);

        // 결과 출력
        if (primeSums.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int sum : primeSums) {
                sb.append(sum).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    // 조합을 통한 합 구하기
    static void combine(int idx, int cnt, int sum) {
        if (cnt == M) {
            if (isPrime(sum)) {
                primeSums.add(sum);
            }
            return;
        }
        if (idx == N) return;

        // 현재 소 선택
        combine(idx + 1, cnt + 1, sum + cows[idx]);
        // 현재 소 미선택
        combine(idx + 1, cnt, sum);
    }

    // 소수 판별
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
