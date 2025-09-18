package solved.silver.S3;
import java.io.*;

public class S3_9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        // N이 홀수면 상근이가 이기고, 짝수면 창영이가 이긴다
        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}