package solved.bronze.B4;
import java.io.*;

public class B4_17863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.charAt(1)).append(s.charAt(2));
        int temp = Integer.parseInt(sb.toString());
        if(temp == 555)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
