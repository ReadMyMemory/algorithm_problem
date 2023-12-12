package solved_ac_step.class2;

import java.io.*;
import java.util.StringTokenizer;

public class S4_1018 {
    public static boolean[][] map;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        // 맵 입력.
        map = new boolean[width][height]; // ex. 10 13 인 경우 세로가 10 가로가 13이다.
        //W = true B = false 로 하자.
        for (int i = 0; i < width; i++) {
            String str = br.readLine();
            for (int j = 0; j < height; j++) {
                if (str.charAt(j) == 'W') // 입력이 W라면 true 저장
                    map[i][j] = true;
                else // 입력이 B라면 false 저장
                    map[i][j] = false;
            }
        }

        int x = width - 7;
        int y = height - 7;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Bruteforce(i, j);
            }
        }
        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void Bruteforce(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // 문제를 다시 보니 왼쪽 상단이 W이거나 B이거나 두가지였다.
        // 따라서 두 경우에서 바꾸는 게 적은 수를 찾으면 되는 문제였다.
        // 왜 이렇게 어렵게 생각했지?
        boolean standard = map[x][y];
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (map[i][j] != standard)
                    count++; // 조건 안맞으면 count 1 추가하기
                standard = !standard; // 칸이 바뀌면 당연히 W => B 또는 B => W가 되어야 한다.
            }
            standard = !standard; // 줄이 바뀌면 당연히 W => B 또는 B => W가 되어야 한다.
        }

        // 그리고 한가지 더 생각하지 못한 점은, 난 당연히 두가지 경우에 대해 다 count를 구해봐야 하는 줄 알았는데
        // 그럴 필요가 없이 기준점이 반대가 되니까 아까 바꾼 개수의 count를 64에서 뺀 값이 기준점이 반대인 경우를 센거다.
        // 역시 아이디어가 중요하다.. 이거 몰랐음 왜 실버4 문제인지 몰랐을듯
        count = Math.min(count, 64 - count); // 첫번째 칸을 기준으로 할 때, 첫번째 칸이랑 반대되는 색을 기준으로 할 때 중 더 작은 걸 count 저장.
        min = Math.min(min, count); // count가 현재 min값보다 작으면 min값을 갱신.
    }





//    static int count = 0;
//    static int minFromBruteForce = 500; // 초기값은 엄청 크게.
//    public static void dfs(boolean[][] arr, int x, int y) {
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, 1, -1};
//
//        boolean standard = arr[x][y]; // 기준점. 이게 true라면 주변은 false가 되어야 함.
//
//        for(int p = 0; p < 4; p++) {
//            int nx = x + dx[p];
//            int ny = y + dy[p];
//
//            if(nx>=0 && nx < 8 && ny>=0 && ny < 8) {
//                if(standard == arr[nx][ny]) {
//                    count++;
//                    arr[nx][ny] = !standard;
//                    dfs(arr, ny, nx);
//                }
//                }
//            }
//    }
//    public static int BruteForce(boolean[][] subArray) {
//        //8x8 안에서도 64개의 기준점을 정해 여기서 가장 적게 판을 바꾸는 횟수를 찾는다.
//
//        for(int i = 0; i < 8; i++) {
//            for(int j = 0; j < 8; j++) {
//                dfs(subArray, i, j);
//                if(minFromBruteForce > count) {
//                    minFromBruteForce = count;
//                }
//                count = 0;
//            }
//        }
//        return minFromBruteForce;
//    }
//
//    public static int SelectSubArray(boolean[][] map, int x, int y) {
//        boolean[][] subArray = new boolean[8][8];
//        // 기준점을 시작점으로 8x8 부분 배열 받기 위한 이중 반복문
//        for(int i = x; i < x+8; i++) {
//            for (int j = y; j < y+8; j++) {
//                subArray[i - x][j - y] = map[i][j];
//            }
//        }
//        int value = BruteForce(subArray);
//        minFromBruteForce = 500; // 다시 엄청 큰 수로 초기화
//        return value;
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int width = Integer.parseInt(st.nextToken());
//        int height = Integer.parseInt(st.nextToken());
//        // 맵 입력.
//        boolean[][] map = new boolean[height][width]; // ex. 10 13 인 경우 세로가 10 가로가 13이다.
//        //W = true B = false 로 하자.
//        for(int i = 0; i < height; i++) {
//            String str = br.readLine();
//            for(int j = 0; j < width; j++) {
//                String cell = String.valueOf(str.charAt(j)); // String을 한글자씩 끊어서 저장.
//                if(cell.equals("W")) // 입력이 W라면 true 저장
//                    map[i][j] = true;
//                else // 입력이 B라면 false 저장
//                    map[i][j] = false;
//            }
//        }
//
//        // 8 x 8 체스판을 선정하는데 있어, 왼쪽 상단을 기준점으로 체스판을 정하자.
//        // 맵, 기준점의 x 좌표, 기준점의 y좌표 이렇게 줄거임.
//        int min = 0; // 최솟값 체크
//        for(int i = 0; i <= height - 8; i++) {
//            for(int j = 0; j <= width - 8; j++) {
//                int answer = SelectSubArray(map, i, j); // 시작점을 하나씩 우측 하단으로 이동해가며 최솟값 찾기.
//                if(min > answer) // 현재 min값보다 새로 구한 최솟값이 더 작으면 min 값 갱신
//                    min = answer;
//            }
//        }
//
//        bw.write(min+"");
//        bw.flush();
//
//
//
//
//    }
}
