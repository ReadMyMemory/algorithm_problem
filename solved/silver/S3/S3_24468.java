package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_24468 {
    static class Ball {
        int pos;
        int dir; // 1: right, -1: left
        
        Ball(int pos, int dir) {
            this.pos = pos;
            this.dir = dir;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        Ball[] balls = new Ball[N];
        
        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            if (dir.equals("R")) {
                balls[i] = new Ball(pos, 1);
            } else {
                balls[i] = new Ball(pos, -1);
            }
        }
        
        int collisionCount = 0;
        
        // T초 동안 시뮬레이션
        for (int time = 1; time <= T; time++) {
            // 각 공을 이동시킴
            for (int i = 0; i < N; i++) {
                balls[i].pos += balls[i].dir;
            }
            
            // 벽과의 충돌 체크
            for (int i = 0; i < N; i++) {
                if (balls[i].pos == 0 || balls[i].pos == L) {
                    balls[i].dir *= -1;
                }
            }
            
            // 공끼리의 충돌 체크
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (balls[i].pos == balls[j].pos) {
                        // 충돌 발생
                        collisionCount++;
                        balls[i].dir *= -1;
                        balls[j].dir *= -1;
                    }
                }
            }
        }
        System.out.println(collisionCount);
    }
}
