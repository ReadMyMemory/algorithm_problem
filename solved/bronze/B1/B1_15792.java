package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

/*
처음엔 printf를 사용해 %.2000f로 출력하고자 했으나 오차가 발생. 따라서 아래와 같은 방법 시도
방법 1. BigDecimal을 활용한 정확한 소수 계산
방법 2. 한자리씩 구해서 string으로 합쳐서 출력

이 중 방법2를 통해 풀어보겠다.
1 / 3을 생각해보면 먼저

    0.3 3
    _______
3 | 1 0
      9
    _______
      1 0
        9
     ________
        1 0

이것을 식으로 구현하면 된다.
 */

public class B1_15792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        sb.append(A / B).append("."); // 정수값 계산

        int temp = 1001;
        while(temp --> 0) { // 여기부턴 소숫값 계산
            A = 10 * (A - B * (A/B)); // 위에서 말했던 직접 나누는 과정을 식으로 표현
            if(A == 0) // 불필요한 0이 나오는 과정 없애기.
                break;
            sb.append(String.valueOf(A/B));
        }
        System.out.println(sb.toString());
    }
}
