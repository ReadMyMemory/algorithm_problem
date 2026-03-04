package solved.bronze.B4;
import java.io.*;

public class B4_31775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean hasL = false, hasK = false, hasP = false;

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (s == null) s = "";
            s = s.trim();
            if (s.isEmpty()) continue;

            char c = s.charAt(0);
            if (c == 'l') hasL = true;
            else if (c == 'k') hasK = true;
            else if (c == 'p') hasP = true;
        }
        System.out.print((hasL && hasK && hasP) ? "GLOBAL" : "PONIX");
    }
}