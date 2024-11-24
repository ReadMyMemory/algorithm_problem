package solved.bronze.B1;
import java.io.*;

/*
A 26 * 0 + ~
AA 26 * 1 + ~
AAA 26 * 1 + 26 * 26 + ~
AAAA 26 * 1 + 26 * 26 + 26 * 26 + 26 + ~

 */

public class B1_16495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        long answer = 0L;
        for(int i = 0; i < length; i++)
            answer += (s.charAt(i) - '0' - 16) * Math.pow(26, length - i - 1);
        System.out.println(answer);
    }
}
