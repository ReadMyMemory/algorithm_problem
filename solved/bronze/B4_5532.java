package solved.bronze;
import java.io.*;

public class B4_5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());


        int num1 = 0;
        int num2 = 0;

        if(A % C != 0)
            num1 = A / C + 1;
        else
            num1 = A / C;
        if(B % D != 0)
            num2 = B / D + 1;
        else
            num2 = B / D;
        System.out.println(L - Math.max(num1, num2));


    }
}
