package solved.bronze;
import java.io.*;

public class B4_5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first_max_burger = Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        int max_burger = Math.min(Integer.parseInt(br.readLine()), first_max_burger);
        int max_drink = Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        System.out.println(max_burger + max_drink - 50);
    }
}
