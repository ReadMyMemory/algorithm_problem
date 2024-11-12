package solved.silver.S3;
import java.io.*;

public class S3_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        문제의 에시를 보고(1,1,1,2,2,3,4,5,7,9,12)
        1번 2번 3번 4번 5번 6번 7번 8번 9번 10번 11번이 만들어지는 과정을 보았다.
        4번 = 1번 3번 (1 1)
        5번 = 4번 (2)
        6번 = 1번 5번 ( 1 2)
        7번 = 2번 6번 ( 1 3)
        8번 = 3번 7번 (1 4)
        9번 = 4번 8번 (2 5)
        10번 = 5번 9번 (2 7)
        11번 = 6번 10번 (3 9)

        조금 생각해보았지만, 규칙이 딱히 떠오르지 않았고 이렇게 보는 시각은 잘못되었던 것 같다.
        11번의 12라는 길이를 만드는 것은 3과 9였지만, 조금 다르게 살펴본다.
        예시에 나온 그림에서 한 변의 길이가 7인 정삼각형의 밑변을 늘려 한 변의 길이가 12인 정삼각형에 맞닿게 하면.
        파도반 수열의 모든 삼각형은 정삼각형이며 60도의 각을 가지기 때문에, 아까 밑변을 늘려 맞닿게 하여 생긴 접점을 기준으로 5 + 7이라는 것을 알 수 있다.

        이번엔 10번인 9를 생각해보자.
        한 변의 길이가 5인 정삼각형의 밑변(예시의 그림에서 우측 변으로 보인다.)을 늘려 한 변의 길이가 9인 정삼각형에 닿기 한 접점을 기준으로 9는 5 + 4라는 것을 알 수 있다.

        이제 알 거 같다.
        dp[N] = dp[N-2] + dp[N-3] 이다!
         */

        // 추가로 틀려서 보니까 dp[100]이 int에서 overflow나더라.
        // 이래서 값을 직접 찍어봐야 하나 보다. long으로 수정.
        int testcase = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= 100; i++)
            dp[i] = dp[i-2] + dp[i-3];
        for(int i = 0; i < testcase; i++)
            bw.write(String.valueOf(dp[Integer.parseInt(br.readLine())])+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
