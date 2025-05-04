package solved.silver.S4;
import java.io.*;

public class S4_3986 {
    public static void main(String[] args) throws IOException {
        // 표준 입력을 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 수 N 읽기
        int N = Integer.parseInt(br.readLine());
        int goodCount = 0;

        // 각 단어에 대해 좋은 단어인지 검사
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (isGoodWord(s)) {
                goodCount++;
            }
        }

        // 좋은 단어 개수 출력
        System.out.println(goodCount);
    }

    // 주어진 문자열이 '좋은 단어'인지 판별하는 메서드
    private static boolean isGoodWord(String s) {
        // 스택을 char 배열로 구현하여 오버헤드 최소화
        char[] stack = new char[s.length()];
        int top = -1;

        // 문자열 순회
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            // 스택이 비어있지 않고, 최상단 문자가 현재 문자와 같으면 팝
            if (top >= 0 && stack[top] == c) {
                top--;
            } else {
                // 그렇지 않으면 현재 문자를 스택에 푸시
                stack[++top] = c;
            }
        }

        // 스택이 비어 있으면 모든 문자가 교차 없이 짝 지어졌다는 의미
        return top == -1;
    }
}
