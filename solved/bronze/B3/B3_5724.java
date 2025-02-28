package solved.bronze.B3;
import java.io.*;

public class B3_5724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            int result = 0;
            for (int i = 1; i <= N; i++)
                result += i * i;

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
