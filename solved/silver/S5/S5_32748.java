package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_32748 {
    // f는 0~9의 치역/정의역이 digit인 일대일 대응(순열) 함수.
    // f(A), f(B)가 주어지면 각 자리마다 역함수 inv를 적용해 A, B를 복원할 수 있다.
    // 그 다음 A+B를 구하고, (A+B)의 각 자리에 f를 적용해 f(A+B)를 만든다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] f = new int[10];
        int[] inv = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int d = 0; d < 10; d++) {
            f[d] = Integer.parseInt(st.nextToken());
            inv[f[d]] = d;
        }

        st = new StringTokenizer(br.readLine());
        String fa = st.nextToken();
        String fb = st.nextToken();

        long A = decode(fa, inv);
        long B = decode(fb, inv);

        long sum = A + B;

        String out = encode(sum, f);
        System.out.print(out);
    }

    private static long decode(String fx, int[] inv) {
        long val = 0;
        for (int i = 0; i < fx.length(); i++) {
            int mapped = fx.charAt(i) - '0';
            int orig = inv[mapped];
            val = val * 10 + orig;
        }
        return val;
    }

    private static String encode(long x, int[] f) {
        char[] digits = Long.toString(x).toCharArray();
        StringBuilder sb = new StringBuilder(digits.length);
        for (char c : digits) {
            int d = c - '0';
            sb.append((char) ('0' + f[d]));
        }
        return sb.toString();
    }
}
