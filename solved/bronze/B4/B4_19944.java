package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_19944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] pieceValues = new int[128];
        pieceValues['P'] = 1; // 백 폰
        pieceValues['N'] = 3; // 백 나이트
        pieceValues['B'] = 3; // 백 비숍
        pieceValues['R'] = 5; // 백 룩
        pieceValues['Q'] = 9; // 백 퀸

        pieceValues['p'] = -1; // 흑 폰
        pieceValues['n'] = -3; // 흑 나이트
        pieceValues['b'] = -3; // 흑 비숍
        pieceValues['r'] = -5; // 흑 룩
        pieceValues['q'] = -9; // 흑 퀸

        int score = 0;

        // 8x8 체스판 읽기
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                score += pieceValues[c]; // 점수 계산
            }
        }

        // 결과 출력
        System.out.println(score);
    }
}
