package solved.silver.S5;
import java.io.*;
import java.util.StringTokenizer;

public class S5_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        겹친 넓이 빼는 법을 생각해봤다.
        색종이의 좌측 하단 점의 좌표(x, y)
        첫 번째 입력 값(x좌표)를 a, 두 번째 입력 값(y좌표)를 b라고 하면,
        일단 임의의 두 색종이가 겹치는 지 안 겹치는 지 확인하는 방법은
        S1의 입력값 a_1 b_1, S2의 입력값 a_2 b_2 일 때,
        Math.abs()를 사용하여 이 값이 10이상이면 안겹치는거고, 10이하면 겹치는거다.
        만약에 겹치면, Math.abs(a_1+10, a_2) * Math.abs(b_1+10, b_2)가 겹친 넓이고 이걸 빼면 된다.
        여기까진 간단해 보인다. 다만, 이제 겹치는 색종이가 3개 이상인 경우다.

        다시 생각해보니 도화지의 크기는 100 * 100 밖에 되지 않는다.
        따라서, 2차원 배열을 만들고 거기에 값을 채워넣는 식으로 한다면, 좋은 아이디어 같다.
        일단 배열을 채워놓고 10000번 체크하여 따질 수도 있겠지만,
        지도를 기록하는 식으로 하고 기록을 하며 count를 하나씩 올리는데, 기록할 때 이미 기록된 지점이라면 count를 세지 않고 넘기는 방법 또한 존재한다.
        이 방법을 사용할 것이다.
         */

        boolean[][] map = new boolean[101][101]; // 편의를 위해 101로 size를 잡았다. 1부터 시작할 것이다.
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st;
        while(number --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x + 10; i++) {
                for(int j = y; j < y + 10; j++) {
                    if(!map[i][j]) { // 아직 채워지지 않은 구역이라면,
                        count++;
                        map[i][j] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
