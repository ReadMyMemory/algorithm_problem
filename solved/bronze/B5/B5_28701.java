package solved.bronze.B5;
import java.io.*;

public class B5_28701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = n * (n + 1) / 2;
        int square = sum * sum;

        System.out.println(sum);
        System.out.println(square);
        System.out.println(square);
    }
}