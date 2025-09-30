package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_2447 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        // 전체를 별로 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '*');
        }

        // 재귀적으로 공백 채우기
        makePattern(0, 0, N);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void makePattern(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        // 3x3 블록으로 나누어 처리
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 가운데 블록(1, 1)은 공백으로 채움
                if (i == 1 && j == 1) {
                    fillBlank(row + i * newSize, col + j * newSize, newSize);
                } else {
                    // 나머지 8개 블록은 재귀 호출
                    makePattern(row + i * newSize, col + j * newSize, newSize);
                }
            }
        }
    }

    static void fillBlank(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
