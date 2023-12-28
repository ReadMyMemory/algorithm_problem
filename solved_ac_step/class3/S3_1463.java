package solved_ac_step.class3;
import java.io.*;

public class S3_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /* 아이디어
       3으로 나누는 것이 수를 가장 줄이는 좋은 방법이라고 생각할 수 있다.
       문제의 에시에 보면 10에서 2를 나눌 수 있음에도 1을 빼고 3으로 나눔으로써 수를 줄였다.
       이처럼 3으로 나눌 수 있도록 만드는 것이 핵심으로 보였다.
       예를 들어 3으로 나누면 나머지가 2가 남는 수가 있다고 하자. 29
       그다음 이 수가 2의 배수면 나누고 / 혹은 2의 배수도 아니면 1을 빼면
       3으로 나누면 나머지가 1인 값이 된다.
       근데 또 40을 예를 들어서, 얘는 3으로 나누면 나머지가 1인 값인데
       2로 나누면 20으로 3으로 나눌 때 나머지가 2가 된다.
       뭔가 규칙이 있는 것 같진 않다.
         */
        int n = Integer.parseInt(br.readLine());
        bw.write(recursive(n, 0)+"");
        bw.flush();
        br.close();
        bw.close();
    }
    static int recursive(int N, int count) {
        // N이 2 미만인 경우 누적된 count값을 반환
        if (N < 2) {
            return count;
        }
        return Math.min(recursive(N / 2, count + 1 + (N % 2)), recursive(N / 3, count + 1 + (N % 3)));
        // 해당 알고리즘의 핵심은 마지막까지 재귀호출했을 때 count 값이 더 작은 걸 뱉어내는 것이다.
    }
}
