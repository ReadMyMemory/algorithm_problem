package solved_ac_step.class3;
import java.io.*;
import java.util.StringTokenizer;

public class S1_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Z를 만드는 조건
        //1. 오른쪽 이동(0, 1) -> 왼쪽 아래 이동(1, -1) -> 오른쪽 이동(0, 1)
        //N > 1 이상이면, 2^(N-1)로 잘라서 먼저 탐색한다.
        //4등분한 배열의 1등분 분량만큼 탐색을 완료하면, 다음 탐색의 시작 지점은(0, 2^(N-1)), (2^(N-1), 0), (2^(N-1), 2^(N-1))
        //그러면 행 열을 기준으로 구역을 확인한 후 한 번 4등분하고,
        //그 안에서 4등분 하고.. 를 반복
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long index = 0;
        while (N > 0) {
            long temp = 1L << (N - 1);
            int quadrant = 0;

            if (r >= temp) {
                quadrant += 2;
                r -= temp;
            }
            if (c >= temp) {
                quadrant += 1;
                c -= temp;
            }

            index += temp * temp * quadrant;
            N--;
        }
        System.out.print(index);
    }
}
