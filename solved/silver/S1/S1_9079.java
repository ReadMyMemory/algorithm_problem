package solved.silver.S1;
import java.io.*;

public class S1_9079 {
    static int[][] board;
    static int minOps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            board = new int[3][3];

            // 입력 받기
            for (int i = 0; i < 3; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line[j].equals("H") ? 0 : 1;
                }
            }

            minOps = Integer.MAX_VALUE;

            // 8가지 연산 (3개 행 + 3개 열 + 2개 대각선)
            // 각 연산을 0번 또는 1번 수행 -> 2^8 = 256가지 경우
            for (int mask = 0; mask < (1 << 8); mask++) {
                int[][] temp = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        temp[i][j] = board[i][j];
                    }
                }

                int ops = 0;

                // 행 뒤집기
                for (int i = 0; i < 3; i++) {
                    if ((mask & (1 << i)) != 0) {
                        for (int j = 0; j < 3; j++) {
                            temp[i][j] = 1 - temp[i][j];
                        }
                        ops++;
                    }
                }

                // 열 뒤집기
                for (int j = 0; j < 3; j++) {
                    if ((mask & (1 << (j + 3))) != 0) {
                        for (int i = 0; i < 3; i++) {
                            temp[i][j] = 1 - temp[i][j];
                        }
                        ops++;
                    }
                }

                // 주 대각선 뒤집기
                if ((mask & (1 << 6)) != 0) {
                    for (int i = 0; i < 3; i++) {
                        temp[i][i] = 1 - temp[i][i];
                    }
                    ops++;
                }

                // 부 대각선 뒤집기
                if ((mask & (1 << 7)) != 0) {
                    for (int i = 0; i < 3; i++) {
                        temp[i][2 - i] = 1 - temp[i][2 - i];
                    }
                    ops++;
                }

                // 모두 같은지 확인
                boolean allSame = true;
                int first = temp[0][0];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (temp[i][j] != first) {
                            allSame = false;
                            break;
                        }
                    }
                    if (!allSame) break;
                }

                if (allSame) {
                    minOps = Math.min(minOps, ops);
                }
            }

            if (minOps == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(minOps).append("\n");
            }
        }
        System.out.print(sb);
    }
}