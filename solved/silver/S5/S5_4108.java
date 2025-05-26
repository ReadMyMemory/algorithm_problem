package solved.silver.S5;
import java.io.*;

public class S5_4108 {
    // 8방향 배열 (상,하,좌,우,좌상,좌하,우상,우하)
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] rc = line.trim().split(" ");
            int R = Integer.parseInt(rc[0]);
            int C = Integer.parseInt(rc[1]);
            if (R == 0 && C == 0) break;

            char[][] map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*') {
                        sb.append('*');
                    } else {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == '*') {
                                cnt++;
                            }
                        }
                        sb.append(cnt);
                    }
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }
    }
}

