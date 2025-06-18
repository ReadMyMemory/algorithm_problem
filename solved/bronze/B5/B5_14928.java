package solved.bronze.B5;
import java.io.*;

//bigInteger 안쓰고하기

public class B5_14928 {
    public static void main(String[] args) throws IOException {
        final int MOD = 20000303;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().trim();
        int result = 0;

        for (int i = 0; i < N.length(); i++) {
            // (현재까지의 값 * 10 + 다음 자리수) % MOD
            result = (int)(((long)result * 10 + (N.charAt(i) - '0')) % MOD);
        }
        System.out.println(result);
    }
}
