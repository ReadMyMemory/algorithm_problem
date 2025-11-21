package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_25633 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] a = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        // dpLen[i] : i번째 도미노를 마지막으로 하는 수열의 최대 길이
        // dpSum[i] : 위 최대 길이를 가지는 수열들의 합 중 최댓값
        int[] dpLen = new int[N];
        long[] dpSum = new long[N];

        int answer = 1;

        for (int i = 0; i < N; i++) {
            dpLen[i] = 1;  // a[i] 혼자만 선택
            dpSum[i] = a[i];

            // i보다 앞에 있는 j 뒤에 i를 붙일 수 있는지 확인
            for (int j = 0; j < i; j++) {
                if (dpSum[j] >= a[i]) { // 앞의 도미노 합이 현재 도미노 무게 이상이어야 넘어짐
                    int candLen = dpLen[j] + 1;
                    long candSum = dpSum[j] + a[i];

                    // 더 긴 수열이 되거나,
                    // 길이는 같은데 합이 더 크면 갱신 (앞으로 더 많은 도미노를 넘길 수 있게)
                    if (candLen > dpLen[i] ||
                            (candLen == dpLen[i] && candSum > dpSum[i])) {
                        dpLen[i] = candLen;
                        dpSum[i] = candSum;
                    }
                }
            }
            if (dpLen[i] > answer) {
                answer = dpLen[i];
            }
        }
        System.out.println(answer);
    }
}
