package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_14936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 각 동작별 소요 시간 계산
        int t1 = N;                  // 모든 버튼
        int t2 = N / 2;              // 짝수 버튼
        int t3 = (N + 1) / 2;        // 홀수 버튼
        int t4 = ((N - 1) / 3) + 1;  // 1,4,7,... (3k+1) 버튼

        // 비교를 위한 최소 주기 길이 (패턴은 6칸 주기)
        int repLen = N > 6 ? 6 : N;

        Set<String> patterns = new HashSet<>();

        // 4가지 동작의 적용 여부를 비트마스크(0~15)로 전수 조사
        for (int mask = 0; mask < 16; mask++) {
            int cost = 0;
            if ((mask & 1) != 0) cost += t1; // 동작1
            if ((mask & 2) != 0) cost += t2; // 동작2
            if ((mask & 4) != 0) cost += t3; // 동작3
            if ((mask & 8) != 0) cost += t4; // 동작4

            if (cost <= m) {
                // 실제 토글된 최종 상태를 repLen 길이만큼 문자열로 구성
                boolean x1 = (mask & 1) != 0;
                boolean x2 = (mask & 2) != 0;
                boolean x3 = (mask & 4) != 0;
                boolean x4 = (mask & 8) != 0;

                char[] state = new char[repLen];
                for (int i = 1; i <= repLen; i++) {
                    int s = 0;
                    if (x1)        s ^= 1;                  // 모두
                    if (x2 && i % 2 == 0) s ^= 1;           // 짝수
                    if (x3 && i % 2 == 1) s ^= 1;           // 홀수
                    if (x4 && (i - 1) % 3 == 0) s ^= 1;     // 3k+1
                    state[i - 1] = (s == 1 ? '1' : '0');
                }
                patterns.add(new String(state));
            }
        }

        System.out.println(patterns.size());
    }
}
