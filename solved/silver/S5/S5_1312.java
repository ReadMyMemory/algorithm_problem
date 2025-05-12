package solved.silver.S5;

import java.io.*;
import java.util.StringTokenizer;

public class S5_1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());  // 분자
        int B = Integer.parseInt(st.nextToken());  // 분모
        int N = Integer.parseInt(st.nextToken());  // 원하는 소수 자릿수

        int remainder = A % B;
        int digit = 0;
        // 1번째 소수 자리부터 N번째까지 반복
        for (int i = 1; i <= N; i++) {
            remainder *= 10;
            digit = remainder / B;
            remainder %= B;
        }
        System.out.println(digit);
    }
}
