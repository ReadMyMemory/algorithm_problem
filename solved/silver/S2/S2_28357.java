package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_28357 {
    static int N;
    static long K;
    static long[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        A = new long[N];
        st = new StringTokenizer(br.readLine());

        long max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, A[i]);
        }

        long left = 0;
        long right = max;
        long answer = max;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (can(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean can(long x) {
        long sum = 0;

        for (long a : A) {
            if (a > x) {
                sum += (a - x);
                if (sum > K) return false;
            }
        }
        return true;
    }
}