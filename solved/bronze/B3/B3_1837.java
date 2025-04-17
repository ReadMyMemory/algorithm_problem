package solved.bronze.B3;
import java.io.*;
import java.math.BigInteger;

public class B3_1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger P = new BigInteger(input[0]); // 암호 P
        int K = Integer.parseInt(input[1]);      // 기준 K

        boolean isGood = true;
        int badPrime = -1;

        // 2부터 K-1까지의 소수로 나누어 떨어지는지 확인
        boolean[] isNotPrime = new boolean[K];
        for (int i = 2; i < K; i++) {
            if (!isNotPrime[i]) {
                BigInteger bi = BigInteger.valueOf(i);
                if (P.mod(bi).equals(BigInteger.ZERO)) {
                    isGood = false;
                    badPrime = i;
                    break;
                }
                for (int j = i * 2; j < K; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        if (isGood) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD " + badPrime);
        }
    }
}
