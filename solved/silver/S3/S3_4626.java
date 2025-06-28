package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_4626 {
    // N / D를 7진법 소수점 아래 pos자리까지 구해서 반환
    static String getBase7Digits(int N, int D, int from, int to) {
        StringBuilder sb = new StringBuilder();
        int rem = N % D; // 나머지로 시작
        for (int i = 0; i <= to; i++) {
            rem *= 7;
            int digit = rem / D;
            rem %= D;
            if (i >= from) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int k = 1; k <= T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            String result = getBase7Digits(N, D, B, E);
            System.out.printf("Problem set %d: %d / %d, base 7 digits %d through %d: %s\n", k, N, D, B, E, result);
        }
    }
}
