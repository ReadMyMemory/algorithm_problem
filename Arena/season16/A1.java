package Arena.season16;
import java.io.*;
import java.util.StringTokenizer;

public class A1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int a,b,d;
            int N = Integer.parseInt(st.nextToken()); // 건너가야 하는 N명의 학생
            int M = Integer.parseInt(st.nextToken()); // 건너갈 때 쓰는 우산 개수 M개
            int K = Integer.parseInt(st.nextToken()); // 우산 당 사람이 들어갈 수 있는 명 수 K명

            //만약 K가 1이라면, N=M을 제외하고선 -1
            //만약 K가 2이라면, x명이 건너갔으면 1명이 자기 우산 제외 모든 우산을 들고 오면 M * K - 1명이 다시 쓰고 간다.
            //결론적으로 N > N - M * K > N - M * K + 1 > n 2 * M * K - 1 이런 식이다.
            //물론 M * K가 N 보다 크다면 그대로 횟수 +1 한다음 끝내면 된다.
            int count = 0;
            while(true) {
                if(K == 1 && M == 1 && N > 1) { // -1이 나오는 경우
                    System.out.println(-1);
                    break;
                }
                if(N - M * K <= 0) { // N이 M * K과 같거나 작음. 한번의 이동으로 끝낼 수 있음.
                    count++;
                    System.out.println(count);
                    break;
                }
                else {
                    N -= (M * K - 1); // 1명은 우산을 가지고 와야하므로 덜 뺌.
                    count+= 2;
                }
            }
        }
    }
}
