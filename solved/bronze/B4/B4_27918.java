package solved.bronze.B4;
import java.io.*;

public class B4_27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d_point = 0;
        int p_point = 0;
        boolean status = true;
        while(N --> 0) {
            String s = br.readLine();
            if(status) {
                if (s.equals("D"))
                    d_point++;
                else
                    p_point++;
            }
            if(Math.abs(d_point - p_point) >= 2)
                status = false;
        }
        System.out.println(d_point+":"+p_point);
    }
}
