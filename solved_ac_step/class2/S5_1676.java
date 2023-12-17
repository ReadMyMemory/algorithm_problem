package solved_ac_step.class2;
import java.io.*;

public class S5_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        /*
        생각해보자
        1! = 1
        2! = 2
        3! = 6
        4! = 24
        5! = 120
        6! = 720
        ... 이건 별로
        소인수분해 관점에서 생각.
        2x5가 발생할때마다 0이 하나 생김. 이거를 이용해서 2x5가 언제 발생하는지를 보면 될 거 같다.
        근데 2는 짝수마다 발생하니까 상대적으로 덜 발생하는 건 5다. 따라서 5의 배수가 발생할때마다 0이 하나씩 추가될거다.
        예를 들어 12다 하면. 12 / 5 = 2 따라서 0은 2개다.
        다만 주의해야 할 게 있다. 5 x 5, 즉 25라면? 0이 2개 생긴다. 125라면? 0이 3개 생긴다.
        다행히 범위가 500!까지기 때문에 5의 배수, 25의 배수, 125의 배수 생각하면 될 거 같다.
        이런 식으로 짜면 될듯.
         */

        int s5 = N/5; // 5x1, 5x2, 5x3 마다 0 추가
        int s25 = N/25; // s5에서 해결하지 못한 5x5에서 0이 하나 더 추가되야함.
        int s125 = N/125; // s25에서 해결하지 못한 5x5x5에서 0이 하나 더 추가되야함.
        int sum = s5 + s25 + s125;
        bw.write(sum + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
