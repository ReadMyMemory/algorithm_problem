package solved.silver.S4;
import java.io.*;

public class S4_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        2자리 수까진 무조건 조건 만족
        3자리 수만 생각하면 된다.
         */
        String number = br.readLine();
        if(number.length() <= 2) {
            System.out.println(Integer.parseInt(number));
        } else {
            int count = 0;
            for (int i = 100; i <= Integer.parseInt(number); i++) {
                String temp = String.valueOf(i);
                int diff = (temp.charAt(0) - '0') - (temp.charAt(1) - '0');
                if(diff == (temp.charAt(1) - '0') - (temp.charAt(2) - '0'))
                    count++;
            }
            System.out.println(99 + count);
        }
    }
}
