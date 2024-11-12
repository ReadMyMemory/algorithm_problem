package solved.silver.S5;
import java.io.*;
import java.util.StringTokenizer;

public class S5_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //하나를 고정시켜놓고 나머지 2개를 맞춰나가고 싶다.
        //카잉 달력과 비슷한 문제로 보이나 다만 E S M의 범위가 정해져있다.
        //따라서 훨씬 쉬워보인다.
        //반복을 가장 최소로 하는 건 범위가 큰 S를 기준으로 잡으면 좋아보인다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long years = S;
        int E_Value = S;
        int M_Value = S;
        if(E_Value > 15) // 아래는 해결했었는데 이쪽을 나머지(%) 처리해버려서 틀린 듯 하다.
            E_Value -= 15;
        if(M_Value > 19) // 코드 복붙하다가 이쪽을 15라고 해버려서 틀렸다. ㅜ 마음이 급했다.
            M_Value -= 19;
        while(true) {
            if(E_Value == E && M_Value == M) // 처음에 S만큼 더했을 때 조건 성립하는 것을 체크한다.
                break;
            E_Value += 28;
            M_Value += 28;
            years += 28;
            while(E_Value > 15) // ~~%15의 나머지를 쓰면 안되는 이유는 15%15=0 이어서다. 0일은 발생할 수 없다.
                E_Value -= 15;
            while(M_Value > 19) // E_Value랑 마찬가지
                M_Value -= 19;
            if(E_Value == E && M_Value == M)
                break;
        }
        System.out.println(years);
    }
}
