package solved.silver.S1;
import java.io.*;

public class S1_2168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);

        long result = x + y - gcd(x, y);
        System.out.println(result);
    }

    // 최대공약수 구하는 함수 (유클리드 호제법)
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
