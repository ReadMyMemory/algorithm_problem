package solved.bronze;
import java.io.*;

public class B5_4999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        if (a.length() >= b.length())
            System.out.println("go");
        else
            System.out.println("no");
    }
}