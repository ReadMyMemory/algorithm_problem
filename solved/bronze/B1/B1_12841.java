package solved.bronze.B1;
import java.io.*;

public class B1_12841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        char[][] map = new char[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        // 데칼코마니 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int mirror = M - 1 - j;
                if (map[i][j] == '.' && map[i][mirror] != '.') {
                    map[i][j] = map[i][mirror];
                } else if (map[i][j] != '.' && map[i][mirror] == '.') {
                    map[i][mirror] = map[i][j];
                }
                // 두 위치 모두 .이거나 둘 다 색깔이 있으면 아무 것도 안 해도 됨 (문제 조건)
            }
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(map[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
