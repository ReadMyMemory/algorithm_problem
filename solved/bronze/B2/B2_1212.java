package solved.bronze.B2;
import java.io.*;

public class B2_1212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        if (s.equals("0")) {
            System.out.print("0");
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            String bin = Integer.toBinaryString(d);
            if (i == 0) {
                sb.append(bin);
            } else {
                if (bin.length() == 1) sb.append("00").append(bin);
                else if (bin.length() == 2) sb.append("0").append(bin);
                else sb.append(bin);
            }
        }
        System.out.print(sb.toString());
    }
}
