package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_1063 {
    // 이동 방향 정의
    static Map<String, int[]> dir = new HashMap<>();
    static {
        dir.put("R", new int[]{1, 0});
        dir.put("L", new int[]{-1, 0});
        dir.put("B", new int[]{0, -1});
        dir.put("T", new int[]{0, 1});
        dir.put("RT", new int[]{1, 1});
        dir.put("LT", new int[]{-1, 1});
        dir.put("RB", new int[]{1, -1});
        dir.put("LB", new int[]{-1, -1});
    }

    // 체스판 범위 체크
    static boolean inRange(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    // 체스좌표 → x, y
    static int[] toXY(String pos) {
        // 'A' ~ 'H' → 0 ~ 7
        int x = pos.charAt(0) - 'A';
        // '1' ~ '8' → 0 ~ 7 (아래가 1, 위가 8)
        int y = pos.charAt(1) - '1';
        return new int[]{x, y};
    }

    // x, y → 체스좌표
    static String toPos(int x, int y) {
        char col = (char) ('A' + x);
        char row = (char) ('1' + y);
        return "" + col + row;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] king = toXY(kingPos);
        int[] stone = toXY(stonePos);

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int[] d = dir.get(move);
            int nx = king[0] + d[0];
            int ny = king[1] + d[1];

            // 킹이 체스판을 벗어나면 무시
            if (!inRange(nx, ny)) continue;

            // 킹의 다음 위치가 돌과 같으면
            if (nx == stone[0] && ny == stone[1]) {
                int sx = stone[0] + d[0];
                int sy = stone[1] + d[1];
                // 돌이 체스판을 벗어나면 무시
                if (!inRange(sx, sy)) continue;
                // 둘 다 이동
                king[0] = nx; king[1] = ny;
                stone[0] = sx; stone[1] = sy;
            } else {
                // 킹만 이동
                king[0] = nx; king[1] = ny;
            }
        }
        System.out.println(toPos(king[0], king[1]));
        System.out.println(toPos(stone[0], stone[1]));
    }
}
