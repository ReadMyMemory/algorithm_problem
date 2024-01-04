package solved_ac_step.class3;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1697 {
    static class Pair {
        int loc, depth;
        public Pair(int loc, int depth) {
            this.loc = loc;
            this.depth = depth;
        }
    }
    static boolean[] visited;
    static boolean valid(int n) {
        if(n < 0 || n > 100000 || visited[n])
            return false;
        return true;
        // 뭐 이렇게 간략하게 쓸 수도 있다 하는데, 가독성을 위해 그냥 위에처럼 쓰겠다.
        // return n >= 0 && n <= 100000 && !visited[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수빈이는 동생보다 좌측에 있을 수도 있지만 우측에 있을 수도 있다.
        //순간 이동은 오른쪽으로만 가능하다. 왼쪽으론 불가능
        //다만 거리를 줄이기 위해 순간 이동을 효과적으로 사용 가능하다.
        //X를 줄여 순간이동을 할 수 있다.
        //상당히 복잡해서 이동을 3가지(+1, -1, x2)로 분류한다음, 최적의 횟수를 찾는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        Queue<Pair> q = new LinkedList<>();
        visited = new boolean[100001];

        q.add(new Pair(N, 0));
        visited[N] = true;

        while(!q.isEmpty()) {
            int location = q.peek().loc;
            int depth = q.peek().depth;
            q.poll();

            if(location == K) {
                System.out.println(depth);
                break;
            }

            if(valid(location - 1)) {
                visited[location - 1] = true;
                q.add(new Pair(location - 1, depth + 1));
            }
            if(valid(location + 1)) {
                visited[location + 1] = true;
                q.add(new Pair(location + 1, depth + 1));
            }
            if(valid(location * 2)) {
                visited[location * 2] = true;
                q.add(new Pair(location * 2, depth + 1));
            }
        }

    }
}
