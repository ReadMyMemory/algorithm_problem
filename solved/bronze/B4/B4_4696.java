package solved.bronze.B4;
import java.io.*;

public class B4_4696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            double w = Double.parseDouble(line);
            if (w == 0) break;

            // 각 단계에서 같은 값 사용
            double s = w, c = w, k = w;
            double total = 1 + w + (w * s) + (w * s * c) + (w * s * c * k);

            sb.append(String.format("%.2f\n", total));
        }
        System.out.print(sb);
    }
}
