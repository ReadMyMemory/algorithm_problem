package solved.silver;
import java.io.*;

public class S5_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /* 1부터 순차적으로 더한 값이 X에 근사할때까지 구한다. 예를 들어 X = 4 였다.
        1 + 2 + 3을 더하다 멈춘다. 그러면 3번째 대각선이다. 그러면 바로 이전 더한 값 1+2에서 몇을 더해야 X가 완성되는지를 구한다.
        그게 순번이고 그 순번을 a라고 하고 X가 N번째 대각선에 위치한 경우 N-a+1/a 라고 쓸 수 있다.
        다만 지그재그가 존재해 N이 몇이냐에 따라 순번 횟수 세는 걸 다르게 하면 되겠다.
         */
        int X = Integer.parseInt(br.readLine());
        int temp = 0; //1부터 계속 더하면서 X와 근사치를 찾을 것이다.
        int i = 1; // 순차적으로 1씩 더하면서 temp에 더할 것이다.
        while(temp < X) {
         temp += i;
         if(temp < X)
             i++;
        }
        int N = i; // 아까 말했던 N번째 대각선이다.
        int value = X - (temp - i); // 마지막 더한 값에서 X를 빼면 얼마만큼 차이나는지 = 그 대각선의 순번
        if(N % 2 == 0) { //짝수번째 대각선은 위에서 아래로
            bw.write(value+"/"+(N-value+1));
        } else { // 홀수번째 대각선은 아래에서 위로
            bw.write((N-value+1)+"/"+value);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
