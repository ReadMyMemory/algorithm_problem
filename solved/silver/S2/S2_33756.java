package solved.silver.S2;
import java.io.*;

public class S2_33756 {
    static boolean isLucky(long n) {
        // 1) 반드시 8의 배수
        if (n % 8 != 0) return false;

        long m = n / 8;

        // 2) 일의 자리는 1~8
        long prev = m % 10;
        if (prev == 0 || prev > 8) return false;
        m /= 10;

        // 3) 각 자릿수는 0~8, 그리고 증가하면 안 됨
        while (m > 0) {
            long cur = m % 10;
            if (cur > 8) return false;
            if (cur > prev) return false;
            prev = cur;
            m /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine().trim());
            sb.append(isLucky(N) ? "Yes" : "No").append('\n');
        }
        System.out.print(sb.toString());
    }
}
