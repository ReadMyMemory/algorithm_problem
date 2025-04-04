package solved.bronze.B4;
import java.io.*;

public class B4_27890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x0 = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int xt = x0;
        for (int t = 0; t < N; t++) {
            if (xt % 2 == 0) {
                xt = (xt / 2) ^ 6;  // 짝수일 때
            } else {
                xt = (2 * xt) ^ 6;  // 홀수일 때
            }
        }
        System.out.println(xt);
    }
}
