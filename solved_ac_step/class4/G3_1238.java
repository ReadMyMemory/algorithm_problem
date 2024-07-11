package solved_ac_step.class4;

/*
N개의 마을과 학생(학생마다 출발지가 다름), X번 마을(도착지), M개의 단방향 도로, i번째 길을 지나는 시간 T_i
최단 시간에 오고 가기를 원하고, 단방향이기 때문에 오고 가는 길이 다르다.
이 중에서 가장 많은 시간을 소비하는 학생을 찾아라.

단방향이긴 하지만, 역방향도 같이 생각하여 각 정점에서의 최단거리를 구하면
시간복잡도를 단축시킬 수 있다.

 */
import java.io.*;
import java.util.StringTokenizer;

public class G3_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드(마을) 개수
        int M = Integer.parseInt(st.nextToken()); // 간선(도로) 개수
        int X = Integer.parseInt(st.nextToken()); // 도착지
    }
}
