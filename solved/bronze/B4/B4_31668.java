package solved.bronze.B4;
import java.io.*;

public class B4_31668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        System.out.println(M / N * K);
        // 한 줄로 쓰고 싶으면 System.out.println(Integer.parseInt(br.readLine()) / Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine())) 라고 써도 될듯하다.
    }
}
