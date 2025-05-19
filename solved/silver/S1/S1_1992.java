package solved.silver.S1;
import java.io.*;

public class S1_1992 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        compress(0, 0, N, sb);
        System.out.println(sb.toString());
    }

    // (x, y)에서 시작해서 size만큼의 영역을 압축
    static void compress(int x, int y, int size, StringBuilder sb) {
        if (isSame(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append('(');
        int newSize = size / 4;
        int half = size / 2;
        compress(x, y, half, sb);                // 왼쪽 위
        compress(x, y + half, half, sb);         // 오른쪽 위
        compress(x + half, y, half, sb);         // 왼쪽 아래
        compress(x + half, y + half, half, sb);  // 오른쪽 아래
        sb.append(')');
    }

    // 주어진 영역이 모두 같은 숫자인지 확인
    static boolean isSame(int x, int y, int size) {
        int val = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}
