package solved.silver.S5;
import java.io.*;

public class S5_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        while (s.length() > 0) {
            if (s.startsWith("pi")) {
                s = s.substring(2);
            } else if (s.startsWith("ka")) {
                s = s.substring(2);
            } else if (s.startsWith("chu")) {
                s = s.substring(3);
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
