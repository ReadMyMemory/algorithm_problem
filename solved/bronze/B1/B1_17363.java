package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

/*
다른 풀이를 봤었는데 90도 회전한 값을 hashmap에 저장한 후 저장된 값이 매치되게 출력하는 방법도 있었다.
좋은 풀이 같더라.
 */

public class B1_17363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        //입력부
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = change(s.charAt(j));
        }

        //출력부
        for(int i = M-1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                bw.write(String.valueOf(map[j][i]));
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    private static char change(char c) {
        switch ((int) c) {
            case 46:
                return 46;
            case 79: // 대문자는 돌려도 대문자인데 이걸 소문자로 바꾸는 실수를 했다.
                return 79;
            case 45:
                return 124;
            case 124:
                return 45;
            case 47:
                return 92;
            case 92:
                return 47;
            case 94:
                return 60;
            case 60:
                return 118;
            case 118:
                return 62;
            case 62:
                return 94;
            default:
                return c;
        }
    }
}
