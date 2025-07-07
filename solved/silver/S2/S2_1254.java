package solved.silver.S2;
import java.io.*;

public class S2_1254 {
    // 팰린드롬인지 판별하는 함수
    public static boolean isPalindrome(String s, int start) {
        int left = start;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int minLength = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i)) {
                minLength = s.length() + i;
                break;
            }
        }
        System.out.println(minLength);
    }
}