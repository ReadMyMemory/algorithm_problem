package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_16401 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카 수
        int N = Integer.parseInt(st.nextToken()); // 과자 수

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if (snacks[i] > maxLen) {
                maxLen = snacks[i];
            }
        }

        int left = 1;
        int right = maxLen;
        int answer = 0;

        // 이분 탐색: 조카에게 줄 과자 길이
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 시도하는 길이

            long cnt = 0; // mid 길이로 잘랐을 때 만들 수 있는 조각 개수
            for (int len : snacks) {
                cnt += (len / mid);
                // 굳이 early stop 안 해도 되지만, 안전하게 하고 싶으면:
                // if (cnt >= M) break;
            }

            if (cnt >= M) {
                // mid 길이로 M명 이상 나눠줄 수 있음 → 길이를 더 늘려본다
                answer = mid;
                left = mid + 1;
            } else {
                // mid 길이로는 M명을 못 채움 → 길이를 줄인다
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
