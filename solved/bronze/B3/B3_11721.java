package solved.bronze.B3;
import java.io.*;

public class B3_11721 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if ((i + 1) % 10 == 0) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
