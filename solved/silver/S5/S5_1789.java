package solved.silver.S5;
import java.io.*;

/*
서로 다른 N개의 자연수의 합이니까, 1부터 더해본다. 그래야 가장 많이 나올 수 있을 것이다.
1부터 계속 더해나가면서 어디까지 더했는지 카운트, 이후 더한 합이 S을 초과하면,
마지막 더한 값에서 하나 뺀 값이 가장 큰 숫자인 것임.
이는 예시인 200에서
1...+19+20 = 210인데,
1..+29 = 200 이렇게 만들 수 있다.
따라서 count를 세고 출력하면 되겠다.
 */

public class S5_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;
        long num = 1;

        while(true) {
            sum += num;
            count++;
            if(sum > N) {
                count--;
                break;
            }
            num++;
        }

        System.out.println(count);
    }
}
