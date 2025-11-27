package solved.gold.G5;
import java.io.*;
import java.util.regex.*;

public class G5_1013 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 1013 CONTACT 패턴: (100+1+ | 01)+
        // ^, $ 를 붙여서 전체 문자열이 정확히 이 패턴과 일치해야만 매칭되도록 한다.
        Pattern pattern = Pattern.compile("^(100+1+|01)+$");

        for (int t = 0; t < T; t++) {
            String s = br.readLine().trim();

            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
