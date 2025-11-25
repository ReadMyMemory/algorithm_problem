package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_14499 {

    // 6방향 정의 : dice[0]=top, [1]=bottom, [2]=north, [3]=south, [4]=west, [5]=east
    static int[] dice = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int x = Integer.parseInt(st.nextToken()); // 초기 주사위 x
        int y = Integer.parseInt(st.nextToken()); // 초기 주사위 y
        int K = Integer.parseInt(st.nextToken()); // 명령 개수

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 동, 서, 북, 남에 대한 좌표 변화
        // 1:동, 2:서, 3:북, 4:남
        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int nx = x + dx[cmd];
            int ny = y + dy[cmd];

            // 지도를 벗어나는 경우는 명령 무시
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            // 주사위 이동
            roll(cmd);

            // 지도와 주사위 바닥 처리
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[1];      // 바닥값을 칸에 복사
            } else {
                dice[1] = map[nx][ny];      // 칸의 값을 바닥으로
                map[nx][ny] = 0;            // 칸은 0으로
            }

            // 윗면 출력
            sb.append(dice[0]).append('\n');

            // 위치 갱신
            x = nx;
            y = ny;
        }
        System.out.print(sb);
    }

    // cmd: 1(동), 2(서), 3(북), 4(남) 주사위 굴리기
    private static void roll(int cmd) {
        int t = dice[0];
        int b = dice[1];
        int n = dice[2];
        int s = dice[3];
        int w = dice[4];
        int e = dice[5];

        switch (cmd) {
            case 1: // 동
                // top <- west, bottom <- east, west <- bottom, east <- top
                dice[0] = w;
                dice[1] = e;
                dice[4] = b;
                dice[5] = t;
                // north, south 그대로
                break;
            case 2: // 서
                // top <- east, bottom <- west, west <- top, east <- bottom
                dice[0] = e;
                dice[1] = w;
                dice[4] = t;
                dice[5] = b;
                break;
            case 3: // 북
                // 북쪽으로 굴리면: top <- south, bottom <- north, north <- top, south <- bottom (이동 전 기준)
                dice[0] = s;
                dice[1] = n;
                dice[2] = t;
                dice[3] = b;
                break;
            case 4: // 남
                // 남쪽으로 굴리면: top <- north, bottom <- south, north <- bottom, south <- top (이동 전 기준)
                dice[0] = n;
                dice[1] = s;
                dice[2] = b;
                dice[3] = t;
                break;
        }
    }
}
