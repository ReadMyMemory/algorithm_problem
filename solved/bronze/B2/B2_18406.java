package solved.bronze.B2;
import java.io.*;

public class B2_18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length() / 2;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < length; i++)
            sum1 += Integer.parseInt(String.valueOf(s.charAt(i)));

        for(int i = length; i < s.length(); i++)
            sum2 += Integer.parseInt(String.valueOf(s.charAt(i)));

        if(sum1 == sum2)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
