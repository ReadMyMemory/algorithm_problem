package solved.silver.S3;
import java.io.*;

public class S3_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 방향: 0=북, 1=동, 2=남, 3=서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int t = 0; t < T; t++) {
            String program = br.readLine();

            int x = 0, y = 0;
            int dir = 0; // 북쪽을 보고 시작

            int minX = 0, maxX = 0;
            int minY = 0, maxY = 0;

            for (int i = 0; i < program.length(); i++) {
                char cmd = program.charAt(i);

                if (cmd == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (cmd == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (cmd == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else if (cmd == 'R') {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int width = maxX - minX;
            int height = maxY - minY;
            int area = width * height;

            sb.append(area).append('\n');
        }
        System.out.print(sb);
    }
}