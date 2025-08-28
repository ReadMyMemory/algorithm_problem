package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_26006 {
    static int N, K;
    static int kingR, kingC;
    static List<int[]> queens = new ArrayList<>();
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kingR = Integer.parseInt(st.nextToken());
        kingC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queens.add(new int[]{r, c});
        }

        // 킹의 현재 위치가 공격받고 있는지 확인
        boolean kingUnderAttack = isUnderAttack(kingR, kingC);

        // 킹이 이동할 수 있는 안전한 위치가 있는지 확인
        int safePositions = 0;
        for (int i = 0; i < 8; i++) {
            int newR = kingR + dr[i];
            int newC = kingC + dc[i];

            // 체스판 범위 확인
            if (newR < 1 || newR > N || newC < 1 || newC > N) continue;

            // 이동할 위치에 퀸이 있는지 확인
            boolean hasQueen = false;
            for (int[] queen : queens) {
                if (queen[0] == newR && queen[1] == newC) {
                    hasQueen = true;
                    break;
                }
            }
            if (hasQueen) continue;

            // 이동할 위치가 공격받는지 확인
            if (!isUnderAttack(newR, newC)) {
                safePositions++;
            }
        }

        // 상태 판단
        String result;
        if (kingUnderAttack) {
            if (safePositions > 0) {
                result = "CHECK";
            } else {
                result = "CHECKMATE";
            }
        } else {
            if (safePositions == 0) {
                result = "STALEMATE";
            } else {
                result = "NONE";
            }
        }
        System.out.println(result);
    }

    static boolean isUnderAttack(int r, int c) {
        for (int[] queen : queens) {
            int qr = queen[0];
            int qc = queen[1];

            // 같은 행
            if (qr == r) return true;
            // 같은 열
            if (qc == c) return true;
            // 대각선
            if (Math.abs(qr - r) == Math.abs(qc - c)) return true;
        }
        return false;
    }
}