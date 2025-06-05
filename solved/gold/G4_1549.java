package solved.gold;
import java.io.*;
import java.util.*;

public class G4_1549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        int bestK = 0;
        long minDiff = Long.MAX_VALUE;

        // k의 범위: 1 ~ n/2
        for (int k = 1; k <= n / 2; k++) {
            List<Long> sums = new ArrayList<>();
            // 길이 k의 구간합 저장
            for (int i = 0; i <= n - k; i++) {
                long sum = prefix[i + k] - prefix[i];
                sums.add(sum);
            }

            long currMin = Long.MAX_VALUE;
            // 겹치지 않게 두 부분 구간 비교
            for (int i = 0; i < sums.size(); i++) {
                for (int j = i + k; j < sums.size(); j++) {
                    long diff = Math.abs(sums.get(i) - sums.get(j));
                    if (diff < currMin) {
                        currMin = diff;
                    }
                    // currMin이 0이면 더 볼 필요 없음 (최소)
                    if (currMin == 0) break;
                }
                if (currMin == 0) break;
            }

            // 결과 갱신
            if (currMin < minDiff || (currMin == minDiff && k > bestK)) {
                minDiff = currMin;
                bestK = k;
            }
        }
        System.out.println(bestK);
        System.out.println(minDiff);
    }
}
