package solved.bronze.B4;
import java.io.*;
public class B4_25704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ori_price = Integer.parseInt(br.readLine());

        if(N < 5)
            System.out.println(ori_price);
        else if(N < 10)
            System.out.println(Math.max(ori_price - 500, 0));
        else if(N < 15)
            System.out.println((int) Math.max(Math.min(ori_price - 500, ori_price * 0.9), 0));
        else if(N < 20)
            System.out.println((int) Math.max(Math.min(ori_price - 2000, ori_price * 0.9), 0));
        else
            System.out.println((int) Math.max(Math.min(ori_price - 2000, ori_price * 0.75), 0));
    }
}
