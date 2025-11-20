package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_27467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());
            int r = (int) (a % 3); // Ai >= 0 이라 음수 처리 불필요
            if (r == 0) cnt0++;
            else if (r == 1) cnt1++;
            else cnt2++; // r == 2
        }

        long p = cnt1 - cnt2;
        long q = cnt0 - cnt2;

        // 실수 출력, 오차 허용 범위 맞추기 위해 충분히 많이 출력
        System.out.printf(java.util.Locale.US, "%.10f %.10f%n", (double) p, (double) q);
    }
}
