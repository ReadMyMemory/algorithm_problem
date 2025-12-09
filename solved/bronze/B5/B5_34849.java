package solved.bronze.B5;
import java.io.*;

public class B5_34849 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine().trim());
        long ops = N * N;

        if (ops <= 100_000_000L) {
            System.out.println("Accepted");
        } else {
            System.out.println("Time limit exceeded");
        }
    }
}
