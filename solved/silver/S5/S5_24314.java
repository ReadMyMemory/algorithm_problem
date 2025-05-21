package solved.silver.S5;
import java.io.*;

public class S5_24314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int a1 = Integer.parseInt(parts[0]);
        int a0 = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        boolean isOmega = true;
        for (int n = n0; n <= 100; n++) {
            int fn = a1 * n + a0;
            int cn = c * n;
            if (fn < cn) {
                isOmega = false;
                break;
            }
        }
        System.out.println(isOmega ? 1 : 0);
    }
}
