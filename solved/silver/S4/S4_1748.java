package solved.silver.S4;
import java.io.*;

/*
1부터 9 ~ 9자리 * 1
10부터 99 ~ 90자리 * 2
100부터 999 900자리 * 3
~~~ 를 이용
 */
public class S4_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int length = N_str.length();
        int answer = 0;
        //N 자릿수 하나 아래까지의 자릿수를 구함. 위에 주석 참고.
        for(int i = 0; i < length-1; i++)
            answer += 9 * (i+1) * (int) Math.pow(10, i);

        int div = (int) (Integer.parseInt(N_str) - Math.pow(10, length-1)); // N자릿수의 시작 수부터 N까지 얼마나 차이 나는지 확인. 예를 들어 N이 130이였다면, 130 - 100 = 30인 것.
        answer += length * (div + 1); // 그만큼의 차 +1에 자릿수만큼 곱해서 더해줌. 예를 들어 N이 130이였다면, 100, 101, ... 130을 이어서 쭉 연결해야 하니 3 * (30+1)이 된다.
        System.out.println(answer);
    }
}
