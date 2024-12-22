package solved.bronze.B4;
import java.io.*;

/*
조건만 잘 따지면 됨.
길이가 2면 그냥 나눠서 더하면 되고
길이가 3이면 중간 숫자가 1이 아니라면, A는 2자리, B는 1자리일 것이고
중간 숫자가 1이라면 마지막 숫자가 0인지만 보면 된다. A는 1자리, B는 10인 경우만 체크해주면 되기 때문.
길이가 4라면 2개씩 나눠서 더하면 된다.
 */

public class B4_15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        if(length == 2)
            System.out.println((s.charAt(0) - '0') + (s.charAt(1) - '0'));
        else if(length == 3) {
            if (s.charAt(1) != '1') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0)).append(s.charAt(1));
                System.out.println(Integer.parseInt(sb.toString()) + s.charAt(2) - '0');
            } else {
                if (s.charAt(2) == '0')
                    System.out.println((s.charAt(0) - '0') + 10);
                else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(0)).append(s.charAt(1));
                    System.out.println(Integer.parseInt(sb.toString()) + s.charAt(2) - '0');
                }
            }
        }
        else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            sb.append(s.charAt(0)).append(s.charAt(1));
            sb1.append(s.charAt(2)).append(s.charAt(3));
            System.out.println(Integer.parseInt(sb.toString()) + Integer.parseInt(sb1.toString()));
        }

    }
}
