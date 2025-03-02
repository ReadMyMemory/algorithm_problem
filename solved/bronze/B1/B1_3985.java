package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine()); // 롤 케이크 길이
        int N = Integer.parseInt(br.readLine()); // 방청객 수

        int[] cake = new int[L + 1]; // 1-based index 사용
        int expectedMax = 0, expectedIndex = 0;
        int[] actualCount = new int[N + 1];

        // 방청객 요청 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int expected = K - P + 1;
            if (expected > expectedMax) {
                expectedMax = expected;
                expectedIndex = i;
            }

            for (int j = P; j <= K; j++) {
                if (cake[j] == 0) { // 아직 배정되지 않은 경우만 할당
                    cake[j] = i;
                }
            }
        }

        // 실제로 가장 많은 조각을 받은 방청객 찾기
        for (int j = 1; j <= L; j++) {
            if (cake[j] != 0) {
                actualCount[cake[j]]++;
            }
        }

        int actualMax = 0, actualIndex = 0;
        for (int i = 1; i <= N; i++) {
            if (actualCount[i] > actualMax) {
                actualMax = actualCount[i];
                actualIndex = i;
            }
        }

        System.out.println(expectedIndex);
        System.out.println(actualIndex);
    }
}
