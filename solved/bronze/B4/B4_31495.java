package solved.bronze.B4;
import java.io.*;
/*
평균 시도가 높은 문제를 한번 풀어보았다.
 */
public class B4_31495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.length() == 1)
            System.out.println("CE");
        else {
            if(s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"' && s.length() > 2) { // 끈따옴표 내부가 빈 문자열인 경우도 체크
                System.out.println(s.replace("\"", ""));
            } else
                System.out.println("CE");
        }
    }
}
