package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_2436 {
    // 유클리드 호제법으로 최대공약수 구하기
    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long G = Long.parseLong(st.nextToken()); // 주어진 최대공약수
        long L = Long.parseLong(st.nextToken()); // 주어진 최소공배수

        long n = L / G; // x * y = n, gcd(x, y) = 1 인 x, y 를 찾는다.

        long bestX = 1;
        long bestY = n;
        long minSum = Long.MAX_VALUE;

        // n 의 약수 i 를 1 ~ sqrt(n) 까지 탐색
        for (long i = 1; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }

            long x = i;
            long y = n / i;

            // x, y 가 서로소여야 함
            if (gcd(x, y) == 1) {
                long sum = x + y;
                if (sum < minSum) {
                    minSum = sum;
                    bestX = x;
                    bestY = y;
                }
            }
        }

        long a = bestX * G;
        long b = bestY * G;

        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        System.out.println(a + " " + b);
    }
}
