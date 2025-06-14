package solved.bronze.B2;
import java.io.*;
import java.util.*;

// 시간이 없어서... 브론즈 풀기

public class B2_1009 {
    // a^b % mod를 구하는 함수 (빠른 거듭제곱)
    static int powMod(int a, int b, int mod) {
        int result = 1;
        a = a % mod;
        while (b > 0) {
            if ((b & 1) == 1) result = (result * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = powMod(a, b, 10);
            if (ans == 0) ans = 10;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
