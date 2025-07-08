package solved.bronze.B2;
import java.io.*;

public class B2_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                // (i + j) % 2 == 0 이면 하얀 칸
                if ((i + j) % 2 == 0 && line.charAt(j) == 'F') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
