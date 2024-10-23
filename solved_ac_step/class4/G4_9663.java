package solved_ac_step.class4;
import java.io.*;

    /*
    4 x 4를 예시로
    depth는 하나의 열이 된다.

    depth
         1 2 3 4
    1    x x x x
    2    x x x x
    3    x x x x
    4    x x x x

    그래서 일차원 배열로 받을 수 있음.
     */


public class G4_9663 {
    static int count = 0;
    static int[] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        nQueens(0);
        System.out.println(count);
    }

    private static void nQueens(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            map[depth] = i;
            if(is_possible(depth))
                nQueens(depth + 1);
        }
    }
    private static boolean is_possible(int row) { // depth를 행으로 생각하겠다.
        //조건1. 같은 열에 놓여있나요?
        for(int i = 0; i < row; i++) {
            if(map[row] == map[i])
                return false;

            //조건2. 같은 대각선상에 놓여있나요? 열의 차이와 행의 차이가 같음.
            else if(Math.abs(row - i) == Math.abs(map[row] - map[i]))
                return false;
        }
        return true;
    }
}
