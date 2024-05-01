package solved_ac_step.class4;
import java.io.*;
import java.util.StringTokenizer;

/*
A, B, C는 각각 int형이 가질 수 있는 최댓값인 2,147,483,647이하의 값을 가질 수 있다.
따라서 long을 사용했다.
추가로, 해당 문제를 풀 땐 지수 법칙과 모듈러 성질을 이용했다.
왜냐면 long의 경우에도 데이터형 크기에 상한선이 존재하고, 마냥 곱해버리면 당얀히 오버플로우가 날 것이기 때문이다.
따라서, 예를 들어 B=30이라서 A를 30번 곱해야 한다면,
A를 30번 곱한 것은 A를 15번 곱한 값을 2번 곱한 것과 같다는, 지수 법칙을 사용한다.
B값이 홀수 였다면, 마지막에 A를 한번 더 곱해주면 되겠다. <-- 이걸 생각하는 게 중요했을지도.

 */

public class S1_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long C;
    static long pow(long A, long e) { // 지수는 영어로 exponent라고 한다.
        if(e == 1)
            return A % C;
        long temp = pow(A, e / 2);
        if(e % 2 == 1)
            return (temp * temp % C) * A % C; // 이렇게 한 이유는 temp * temp * A 했을 때 long에서 overflow를 막기 위함이다.
        return temp * temp % C;
    }
}
