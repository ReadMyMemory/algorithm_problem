package solved.bronze.B3;
import java.io.*;
import java.math.BigInteger;

public class B3_5893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(br.readLine(), 2);
        BigInteger result = num.multiply(BigInteger.valueOf(17));
        System.out.println(result.toString(2));
    }
}
