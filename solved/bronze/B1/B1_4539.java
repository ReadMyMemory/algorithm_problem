package solved.bronze.B1;
import java.io.*;

public class B1_4539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int factor = 10;

            while (x >= factor) {
                x = (x + factor / 2) / factor * factor;
                factor *= 10;
            }
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}
