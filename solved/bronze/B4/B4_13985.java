package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

//delim을 여러개 쓰고 싶으면 그냥 이어 붙여서 쓰면 된다. 처음에 |를 붙여야한다고 써있던데 그게 아니라 그냥 한칸당 하나인듯? 그래서 + = 공백 3개를 delim으로 넣었다.

public class B4_13985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+= ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(A + " " + B + " " + C);
        if(A + B == C)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
