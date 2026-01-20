package solved.bronze.B3;
import java.io.*;
import java.math.BigInteger;

public class B3_24264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        BigInteger bn = BigInteger.valueOf(n);
        BigInteger cnt = bn.multiply(bn);

        System.out.println(cnt);
        System.out.println(2);
    }
}
