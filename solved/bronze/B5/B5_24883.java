package solved.bronze.B5;
import java.io.*;

public class B5_24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        if(c == 'n' || c == 'N') System.out.println("Naver D2");
        else System.out.println("Naver Whale");
    }
}
