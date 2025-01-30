package solved.bronze.B5;
import java.io.*;

public class B5_20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double answer1 = N * 0.78;
        double answer2 = N - N * 0.2 * 0.22;
        System.out.println((int) answer1 + " "+ (int) answer2);
    }
}
