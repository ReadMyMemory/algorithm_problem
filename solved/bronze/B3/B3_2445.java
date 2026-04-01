package solved.bronze.B3;
import java.io.*;

public class B3_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 위쪽 부분
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            for (int j = 0; j < 2 * (N - i); j++) {
                sb.append(" ");
            }

            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        // 아래쪽 부분
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            for (int j = 0; j < 2 * (N - i); j++) {
                sb.append(" ");
            }

            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}