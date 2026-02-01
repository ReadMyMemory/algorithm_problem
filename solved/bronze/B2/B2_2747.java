package solved.bronze.B2;
import java.io.*;

public class B2_2747 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            System.out.print(0);
            return;
        }
        if (n == 1) {
            System.out.print(1);
            return;
        }

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.print(b);
    }
}
