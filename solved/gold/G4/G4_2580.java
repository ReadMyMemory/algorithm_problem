package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_2580 {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
    }

    // blanks 리스트의 idx번째 빈칸을 채우는 백트래킹!!
    static void dfs(int idx) {
        if (idx == blanks.size()) {
            printBoard();
            System.exit(0); // 정답이 하나 보장되므로 출력 후 종료
        }

        int[] cur = blanks.get(idx);
        int r = cur[0];
        int c = cur[1];

        for (int num = 1; num <= 9; num++) {
            if (isPossible(r, c, num)) {
                board[r][c] = num;
                dfs(idx + 1);
                board[r][c] = 0; // 되돌리기
            }
        }
    }

    // 해당 위치에 num을 넣을 수 있는지 검사
    static boolean isPossible(int r, int c, int num) {
        // 같은 행 검사
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }

        // 같은 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) {
                return false;
            }
        }

        // 같은 3x3 박스 검사
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}