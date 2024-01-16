package solved_ac_step.class3;
import java.io.*;
public class S3_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*2xn 타일링 문제는 피보나치로 풀 수 있는 문제였다.
        2번도 그럴까? 일단 나열해본다.
        1 -> 1가지
        2 -> || == ㅁ  3가지
        3은 |||  ==|  |== ㅁ| |ㅁ  5가지
        4는 |||| 과 ||ㅁ ||== x 3 과 ㅁㅁ == == 그리고 ㅁ== x 2  11가지
        누가 봐도 피보나치 수열 아니다..
        2와 3을 다시 본다.
        2에서 |를 생각하고 나머지 2칸을 보면 2와 일치하기 때문에 3 x 2 라고 생각하겠지만, |||은 다르다고 할 수 없기 때문에 -1이다.
        4에서도 |를 생각하고 나머지 3칸을 보면
        |  |||  이건 -1 해야한다.
        || == / || ㅁ / | ㅁ | / | == | / == || / ㅁ || 6가지
        다만 |를 기준으로 하지 않는 경우가 있어 ㅁㅁ == ㅁ== ==ㅁ 이 추가되어
        11
        3에서 |||에 |가 하나 붙은 것 / 나머지 4개에 대해선 바가 왼쪽 오른쪽에 붙느냐에 따라 2가지 경우가 있음. 다만 |ㅁ| |==|은 겹치니 4 * 2 - 2 = 6 / 나머지 2^(n-2)
        1 + (이전 값 - 1) * 2 + 2^(n-2) ?
        근데
        dp[i] = dp[i-1] * 2 + 1 이렇게 하니 맞더라. 이유가 뭐지..?

       그럼 가로 길이가 홀수라면
       이전 가로 길이에서 나오는 가짓수 x 2 - 1 이다.
       그럼 가로 길이가 짝수라면
       이전 가로 길이에서 나오는 가짓수 x 2 -1 + 2^(n/2) (이건 가로 길이를 2로 기준으로 했을 때 ㅁ 또는 == 이 배치될 수 있어서)
       ㅁㅁㅁ / ㅁ == == /  == ㅁ == / == == ㅁ / ㅁ ㅁ == / == ㅁ ㅁ / ㅁ == ㅁ / == == == / 길이가 6인 경우 2^3 = 8가지다. 맞음.
       이런 규칙이겠다 싶었다. 근데 그건 아니였고, 값을 전개하다보니 어떠한 규칙이 보여서 보니까
       하지만 짝수의 경우 저런 규칙이 아니라 dp[i] = dp[i-1] * 2 + 1 이런 규칙으로 하니 결과값이 제대로 나오더라
       이걸 dp로 전개하면 될듯.
         */
        int number = Integer.parseInt(br.readLine());
        int[] dp = new int[number+1]; // 인덱스를 보기 쉽게

        dp[1] = 1; // 가로 길이 1이면
        if(number >= 2)
            dp[2] = 3;
        for(int i = 3; i <= number; i++) {
            if(i % 2 == 0) // 짝수라면
                dp[i] = dp[i-1] * 2 + 1;
            else // 홀수라면
                dp[i] = dp[i-1] * 2 - 1;
        }
        System.out.println(dp[number]);
    }

    static int multiple(int n) {
        int count = 0;
        int value = 1;
        while(count < n) {
            value *= 2;
            count++;
        }
        return value;
    }

}
