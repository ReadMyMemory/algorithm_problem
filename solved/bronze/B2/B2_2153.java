package solved.bronze.B2;
import java.io.*;
public class B2_2153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)) // 참고로 소문자가 대문자보다 아스키코드 값이 더 크다. a는 97, A는 65다.
                sum += c + 1 - 'a';
            else
                sum += c + 27 - 'A';
        }
        System.out.println(isPrime(sum)?"It is a prime word.":"It is not a prime word.");
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
