package solved;
import java.util.*;
import java.io.*;

public class a2667 {
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 탐색 중 상하 or 좌우
    static int[] dy = {1, -1, 0, 0}; // 상하좌우 탐색 중 상하 or 좌우
    static int[][] map; // 크기가 정해지지 않은 지도 배열
    static boolean[][] visit; // 방문한 장소를 표시하는 배열
    static int n;
    static int nx, ny; // 현재의 x, 현재의 y, 위치 표시다. dfs
    static int number = 0; // 이건 집마다 붙이는 번호표. 1번 동네, 2번 동네.. 이런 느낌, 총 단지 수
    static int count; // 집 개수를 새고 이걸 houses ArrayList에 저장할거다.

    public static void main(String[] args) throws IOException {
        // Scanner와 비슷함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.out.print와 비슷함
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> houses = new ArrayList<Integer>();
        n = Integer.parseInt(br.readLine()); // 지도의 크기를 받아 n에 저장. 이때 parseInt를 사용하여 string을 int로 형변환
        map = new int[n][n];
        visit = new boolean[n][n]; // true, false로 방문 여부 구분

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false && map[i][j] == 1) {
                    count = 0;
                    number++;
                    dfs(i, j);
                    houses.add(count);
                }
            }
        }

        Collections.sort(houses); // 컬렉션 sorting 이용
        // 줄바꿈은 bw.newLine(); 으로도 할 수 있더라.
        // 그리고 bw.write(); 안하고 bw.append(); 해도 되고 이게 효율적이라고 한다. 이유? 아래에 적어놓음
        bw.append(number + "\n"); // 집 번호표 개수 표시
        for (int num : houses) {
            bw.append(num + "\n");
        }

        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close();
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;
        map[a][b] = number;
        count++;

        for (int i = 0; i < 4; i++) {
            nx = a + dx[i]; // 상하좌우 탐색
            ny = b + dy[i]; // 상하좌우 탐색
            // if 문으로 범위 조건을 지정
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (visit[nx][ny] == false && map[nx][ny] == 1) {
                    visit[nx][ny] = true; // 방문한 곳을 표시해주기
                    map[nx][ny] = number; // 집마다 붙이는 번호표 number
                    dfs(nx, ny); // recursion
                }
            }
        }
    }
}
