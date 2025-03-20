package solved.bronze.B3;
import java.io.*;

public class B3_33541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int year = X + 1;
        while (year <= 9999) {
            int front = year / 100;
            int back = year % 100;
            int sum = front + back;
            if (sum * sum == year) {
                System.out.println(year);
                return;
            }
            year++;
        }
        System.out.println(-1);
    }
}
