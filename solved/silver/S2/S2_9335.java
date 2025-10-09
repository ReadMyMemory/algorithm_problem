package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_9335 {
    static int n;
    static int[] friends; // 각 사용자의 친구 정보를 비트마스크로 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            friends = new int[n];

            // 각 사용자의 친구 정보를 비트마스크로 저장
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());

                // 자기 자신도 광고를 볼 수 있음
                friends[i] = (1 << i);

                // 친구들도 광고를 볼 수 있음
                for (int j = 0; j < d; j++) {
                    int friend = Integer.parseInt(st.nextToken()) - 1; // 0-indexed
                    friends[i] |= (1 << friend);
                }
            }

            int answer = Integer.MAX_VALUE;

            // 모든 가능한 조합을 시도 (2^n)
            for (int mask = 0; mask < (1 << n); mask++) {
                int covered = 0; // 광고를 본 사용자들

                // mask에서 선택된 사용자들의 담벼락에 광고 게시
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        covered |= friends[i];
                    }
                }

                // 모든 사용자가 광고를 봤는지 확인
                if (covered == (1 << n) - 1) {
                    answer = Math.min(answer, Integer.bitCount(mask));
                }
            }

            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}