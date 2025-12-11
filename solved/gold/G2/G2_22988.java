package solved.gold.G2;
import java.io.*;
import java.util.*;

public class G2_22988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] tmp = new long[N];
        int m = 0;              // X 미만 용기 개수
        long answer = 0;        // 꽉 찬 용기 개수

        int read = 0;
        while (read < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && read < N) {
                long c = Long.parseLong(st.nextToken());
                if (c == X) {
                    // 이미 꽉 찬 용기
                    answer++;
                } else {
                    tmp[m++] = c;   // X 미만 용기만 따로 저장
                }
                read++;
            }
        }

        long[] arr = Arrays.copyOf(tmp, m);
        Arrays.sort(arr);

        long threshold = (X + 1) / 2; // ceil(X / 2)

        // 2개씩 묶어서 합이 threshold 이상인 최대 쌍 개수 구하기 (두 포인터)
        int left = 0;
        int right = m - 1;
        long pairCount = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];
            if (sum >= threshold) {
                // 이 둘을 쌍으로 사용
                pairCount++;
                left++;
                right--;
            } else {
                // 가장 작은 것은 이 오른쪽과도 안 되므로
                // 더 큰 것과 시도하기 위해 left를 올린다.
                left++;
            }
        }

        long remain = m - 2 * pairCount; // 쌍으로 못 쓴 용기 개수

        // 쌍마다 꽉 찬 용기 1개, 남은 것들은 3개씩 묶어 1개씩
        answer += pairCount + remain / 3;

        System.out.println(answer);
    }
}
