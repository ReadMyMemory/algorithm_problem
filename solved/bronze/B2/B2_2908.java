package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_2908 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int ra = reverse3(a);
        int rb = reverse3(b);

        System.out.print(Math.max(ra, rb));
    }

    private static int reverse3(String s) {
        // 3자리 수라는 조건이 있으니 간단히 뒤집기
        return (s.charAt(2) - '0') * 100 + (s.charAt(1) - '0') * 10 + (s.charAt(0) - '0');
    }
}
