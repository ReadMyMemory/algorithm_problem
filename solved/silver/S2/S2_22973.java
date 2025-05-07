package solved.silver.S2;
import java.io.*;

public class S2_22973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine().trim());

        // K == 0 이면 이미 제자리에 있으므로 0점프
        if (K == 0) {
            System.out.println(0);
            return;
        }
        // 짝수 K(≠0)는 도달 불가
        if (K % 2 == 0) {
            System.out.println(-1);
            return;
        }

        long absK = Math.abs(K);
        // 2^n - 1 >= absK 이어야 하므로 2^n >= absK + 1
        long target = absK + 1;

        int n = 0;
        // absK 최대 10^12 이므로 n이 대략 40 이하에서 끝남 → long shift 안전
        while ((1L << n) < target) {
            n++;
        }

        System.out.println(n);
    }
}
