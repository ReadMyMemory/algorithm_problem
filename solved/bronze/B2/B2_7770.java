package solved.bronze.B2;
import java.io.*;

/*
높이 2인 안정적인 피라미드를 만들면서 가장 적게 블록을 사용하는 것은
2층 1개, 1층 5개의 십자가 모양이다.

1층은
    +
  + + +
    +

2층은

    +

인 셈이다.
만약에 3층을 만든다고 하면?
2층은 아까의 1층과 동일해질 것이고
1층은 기존의 1층에서 테두리에 한개씩 추가되는 형태일 것이다.
따라서
8개가 추가되므로
13 + 5 + 1의 19개의 형태가 된다.
    *
  * + *
* + + + *
  * + *
    *



그러면 4층은?
12개를 추가해야한다.
25 + 13 + 5 + 1 = 44개가 된다.
여기서 규칙은 다음과 같다.
가운데를 기준으로 테두리가 한줄씩 증가하는 형태라고 생각하면 되므로,
점화식은 다음과 같다.
S_n= S_(n-1) + n * 2 + (n-2) * 2
 */

public class B2_7770 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100000];
        dp[1] = 1;
        int count = 0;
        for(int i = 2; i <= 100000; i++) {
            dp[i] = dp[i-1] + (4 * i - 4);
            if(dp[i] > n) {
                count = i - 1;
                break;
            }
        }
        System.out.println(count);
    }
}
