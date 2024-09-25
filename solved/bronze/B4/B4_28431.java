package solved.bronze.B4;
import java.io.*;

// 어쨌든 짝만 맞으면 되니까, 같은 숫자 4번 나오는 경우도 인정이다.

public class B4_28431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = new int[10];

        //입력부
        int temp = 5;
        while(temp --> 0)
            map[Integer.parseInt(br.readLine())]++;

        //출력부
        for(int i = 0; i < 10; i++) {
            if(map[i] != 0 && map[i] % 2 != 0) // 1번 이상 나온 숫자면서, 짝을 맞추지 못한 숫자를 찾기
                System.out.println(i);
        }
    }
}
