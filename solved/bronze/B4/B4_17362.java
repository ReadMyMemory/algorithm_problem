package solved.bronze.B4;
import java.io.*;

/*
생각보다 간단한데, 8로 나눴을때의 나머지 값이 규칙성을 가지므로, 이를 기반으로 찾아가면 된다.
엄지는 1
검지는 2 or 0
중지는 3 or 7
약지는 4 or 6
소지는 5다.
 */

public class B4_17362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int value = (int) n % 8;
        if(value == 1)
            System.out.println(1);
        else if(value == 0 || value == 2)
            System.out.println(2);
        else if(value == 3 || value == 7)
            System.out.println(3);
        else if(value == 4 || value == 6)
            System.out.println(4);
        else
            System.out.println(5);
    }
}
