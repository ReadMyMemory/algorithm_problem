package solved.silver.S2;
import java.io.*;

public class S2_23304 {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        if (isAkaraka(0, s.length() - 1)) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }
    }

    static boolean isAkaraka(int left, int right) {
        if (!isPalindrome(left, right)) {
            return false;
        }

        int len = right - left + 1;

        if (len == 1) {
            return true;
        }

        int half = len / 2;

        return isAkaraka(left, left + half - 1)
                && isAkaraka(right - half + 1, right);
    }

    static boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}