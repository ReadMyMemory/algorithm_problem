package solved.bronze.B1;
import java.io.*;

public class B1_12090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 19개의 한글 초성(호환용 자모) 배열
        String[] CHO = {
                "ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ",
                "ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"
        };

        StringBuilder sb = new StringBuilder();
        final int HANGUL_BASE = 0xAC00;
        final int CHO_UNIT = 21 * 28;  // 중성 21 * 종성 28

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int code = ch - HANGUL_BASE;          // 음절 블록 내 상대 코드
            int choIndex = code / CHO_UNIT;       // 초성 인덱스 계산
            sb.append(CHO[choIndex]);             // 해당 초성 추가
        }

        System.out.println(sb.toString());
    }
}
