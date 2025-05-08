package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_32625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // N의 약수 중 N 자신을 제외한 것들 구하기
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i < N) divisors.add(i);
                int j = N / i;
                if (j != i && j < N) divisors.add(j);
            }
        }
        // 각 구간 크기 k에 대해 검사
        for (int k : divisors) {
            int segments = N / k;
            // 첫 번째 구간의 min+max를 기준으로 설정
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                if (A[i] < min) min = A[i];
                if (A[i] > max) max = A[i];
            }
            int target = min + max;
            boolean ok = true;
            // 나머지 구간 검사
            for (int s = 1; s < segments; s++) {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                int start = s * k;
                for (int i = start; i < start + k; i++) {
                    if (A[i] < min) min = A[i];
                    if (A[i] > max) max = A[i];
                }
                if (min + max != target) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
