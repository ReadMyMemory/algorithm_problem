package solved.bronze.B3;
import java.io.*;

public class B3_5613 {
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sum += Integer.parseInt(br.readLine());
        while(true) {
            String sign = br.readLine();
            if(sign.equals("="))
                break;
            else
                calc(sign, Integer.parseInt(br.readLine()));
        }
        System.out.println(sum);
    }

    private static void calc(String sign, int next) {
        switch (sign) {
            case "+":
                sum += next;
                break;
            case "-":
                sum -= next;
                break;
            case "*":
                sum *= next;
                break;
            case "/":
                sum = (int) (sum / next); // 나눗셈 계산할 때 소수점을 버린다고 했다.
                break;
        }
    }
}
