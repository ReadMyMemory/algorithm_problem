package solved.bronze.B3;
import java.io.*;

public class B3_26594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int max = 1;
        int count = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
                max = Math.max(max, count);
            } else {
                prev = s.charAt(i);
                count = 1;
            }
        }
        System.out.println(max);
    }
}
