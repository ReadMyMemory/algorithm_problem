package solved.silver.S5;
import java.io.*;
import java.math.*;
import java.util.*;

public class S5_17504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // g = [a1; a2, ..., aN] 계산을 뒤에서부터
        BigInteger num = BigInteger.valueOf(a[N - 1]); // 분자
        BigInteger den = BigInteger.ONE;               // 분모
        for (int i = N - 2; i >= 0; i--) {
            BigInteger newNum = BigInteger.valueOf(a[i]).multiply(num).add(den);
            BigInteger newDen = num;
            num = newNum;
            den = newDen;
        }
        // g = num/den 이므로 남은 무게 = (g-1)/g = (num-den)/num
        BigInteger P = num.subtract(den);
        BigInteger Q = num;
        // 기약분수로 만들기
        BigInteger gcf = P.gcd(Q);
        P = P.divide(gcf);
        Q = Q.divide(gcf);
        System.out.println(P + " " + Q);
    }
}
