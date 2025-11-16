package solved.silver.S2;
import java.io.*;

public class S2_10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int open = 0;        // 현재 열려 있는 쇠막대기 수
        int result = 0;      // 잘려서 생긴 조각 수
        char prev = ' ';     // 직전 문자

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 일단 막대 시작이라고 가정하고 open 증가
                open++;
            } else { // c == ')'
                // 한 쌍은 무조건 끝났으니 open 감소
                open--;

                if (prev == '(') {
                    // 직전이 '('이면 레이저 "()" 였던 것
                    // 레이저가 쏜 순간, 열려 있는 막대기 수만큼 조각이 생김
                    result += open;
                } else {
                    // 막대기의 끝부분
                    result += 1;
                }
            }
            prev = c;
        }
        System.out.println(result);
    }
}
