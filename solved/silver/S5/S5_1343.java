package solved.silver.S5;
import java.io.*;

public class S5_1343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = board.length();

        while (i < n) {
            if (board.charAt(i) == '.') {
                sb.append('.');
                i++;
                continue;
            }

            if (i + 4 <= n && board.substring(i, i + 4).equals("XXXX")) {
                sb.append("AAAA");
                i += 4;
            }
            else if (i + 2 <= n && board.substring(i, i + 2).equals("XX")) {
                sb.append("BB");
                i += 2;
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sb.toString());
    }
}