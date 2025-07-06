package solved.silver.S1;
import java.io.*;

public class S1_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lr = br.readLine().split(" ");
        String L = lr[0];
        String R = lr[1];

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) != R.charAt(i)) break;
            if (L.charAt(i) == '8') count++;
        }

        System.out.println(count);
    }
}
