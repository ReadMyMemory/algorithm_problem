package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class B1_11050 {

    static int factorial(int n) { //시간복잡도 상 재귀보단 반복문이 더 나아보인다.
        int value = 0;
        if(n == 0 || n == 1) // n==1은 굳이 안넣어도 되지만, 가능한 계산을 줄이기 위한 일환
            return 1;
        while(true) {
            if(value == 0) {
                value = n;
                n--;
            }
            else if(n == 1)
                break;
            else {
                value *= n;
                n--;
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //이항 계수란 무엇인가?
        //쉽게 말해 nCk 말하는 거다. 예시인 5 2를 보면 5C2 = 5! / 2! * 3! = 120 / 12 = 10이다. N의 범위가 10까지고 10!은 Integer.MAX_VALUE보다 작으니 그대로 구현해도 된다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println( factorial(N) / (factorial(K) * factorial(N-K)) ); // K! * N-K! 또한 Integer.MAX_VALUE보다 작으니 그대로 구현해도 된다.


    }
}
