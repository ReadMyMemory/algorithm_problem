package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_14489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(br.readLine());

        long sum = A - C + B - C;
        //A, B, C가 모두 0일 때, 또는 가격이 딱 맞을 때를 제외하고 생각함. 따라서 sum 조건에 = 추가
        if(sum >= 0)
            System.out.println(sum);
        else
            System.out.println(A+B);
    }
}
