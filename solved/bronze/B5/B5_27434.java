package solved.bronze.B5;
import java.io.*;
import java.math.BigInteger;

/*
그냥 곱하니까 시간초과가 남
브론즈 5 난이도 맞나?
 */

public class B5_27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0)
            System.out.println(1);
        else
            System.out.println(factorial(1, n));
    }

    private static BigInteger factorial(int start, int end) {
        if(start == end)
            return BigInteger.valueOf(end);

        return factorial(start, (start + end) / 2).multiply(factorial((start + end) / 2 + 1, end));
    }
}
