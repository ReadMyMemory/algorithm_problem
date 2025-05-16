package solved.silver.S4;
import java.io.*;

public class S4_9214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int test = 1;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("0")) break;
            String result = findFirstTerm(line);
            System.out.println("Test " + test + ": " + result);
            test++;
        }
    }

    private static String findFirstTerm(String s) {
        while (true) {
            String prev = prevTerm(s);
            if (prev == null || prev.equals(s)) {
                return s;
            }
            s = prev;
        }
    }

    private static String prevTerm(String s) {
        if (s.length() % 2 != 0) return null;
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            char countChar = s.charAt(i);
            char digitChar = s.charAt(i + 1);
            if (!Character.isDigit(countChar) || !Character.isDigit(digitChar)) return null;
            int count = countChar - '0';
            if (count <= 0) return null;
            for (int k = 0; k < count; k++) {
                p.append(digitChar);
            }
        }
        String encoded = encode(p.toString());
        if (!s.equals(encoded)) return null;
        return p.toString();
    }

    private static String encode(String p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < p.length()) {
            char c = p.charAt(i);
            int cnt = 1;
            i++;
            while (i < p.length() && p.charAt(i) == c) {
                cnt++;
                i++;
            }
            sb.append(cnt).append(c);
        }
        return sb.toString();
    }
}
