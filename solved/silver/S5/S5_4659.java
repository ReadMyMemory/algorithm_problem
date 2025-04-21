package solved.silver.S5;
import java.io.*;

public class S5_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw;
        while ((pw = br.readLine()) != null) {
            if (pw.equals("end")) break;
            if (isAcceptable(pw)) {
                System.out.println("<" + pw + "> is acceptable.");
            } else {
                System.out.println("<" + pw + "> is not acceptable.");
            }
        }
    }

    private static boolean isAcceptable(String pw) {
        // 1) 모음을 하나 이상 포함해야 한다.
        if (!pw.matches(".*[aeiou].*")) {
            return false;
        }
        // 2) 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
        int consV = 0, consC = 0;
        for (char c : pw.toCharArray()) {
            if (isVowel(c)) {
                consV++;
                consC = 0;
            } else {
                consC++;
                consV = 0;
            }
            if (consV == 3 || consC == 3) {
                return false;
            }
        }
        // 3) 같은 글자가 연속으로 두 번 오면 안 된다. (단, ee, oo는 허용)
        for (int i = 1; i < pw.length(); i++) {
            if (pw.charAt(i) == pw.charAt(i - 1)) {
                char c = pw.charAt(i);
                if (!(c == 'e' || c == 'o')) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
