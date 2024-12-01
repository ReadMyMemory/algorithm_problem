package solved.bronze.B2;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class B2_2052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double answer = Math.pow(0.5, N);
        BigDecimal bd = new BigDecimal(answer);
        System.out.println(bd.setScale(N, RoundingMode.HALF_UP).toPlainString());
    }
}
