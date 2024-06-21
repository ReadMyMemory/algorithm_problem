package solved.bronze.B4;
import java.io.*;

public class B4_24723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* 아이디어
        높이가 1이다. 2
        높이가 2다. 4
        높이가 3이다. 8
        높이가 4다.
        -> 위에서 3번째 기준 해당 블록에 도달할 수 있는 가짓수 1 2 1
        -> 위에서 4번째 기준 해당 블록에 도달할 수 있는 가짓수 1 3 3 1
         하나의 블록에서 내려올 수 있는 건 2가지니까(높이 1일때 참고) 8 * 2 = 16
        높이가 5다.
        -> 위에서 4번째 기준 해당 블록에 도달할 수 있는 가짓수 1 3 3 1
        -> 위에서 5번째 기준 해당 블록에 도달할 수 있는 가짓수 1 4 6 4 1
        하나의 블록에서 내려올 수 있는 건 2가지니까(높이 1일때 참고) 16 * 2 = 32
       사실상 2의 제곱수 였던 것이다.
       이게 왜 이런가? 하면 트리 구조를 생각하면 될 듯 하다.
         */
        int number = Integer.parseInt(br.readLine());
        int value = 1;
        for(int i = 1; i <= number; i++)
            value *= 2;
        System.out.println(value);
    }
}
