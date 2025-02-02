package solved.bronze.B3;
import java.io.*;
import java.time.LocalDate;

/*
쉬운 문제가 때론 정말 좋은 것 같다. LocalDate라는 것을 이용,isBefore 메서드를 이용해 쉽게 비교할 수 있음을 알았다.
 */

public class B3_28454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LocalDate currentDate = LocalDate.parse(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int gifts = 0;

        while (N --> 0) {
            LocalDate expiryDate = LocalDate.parse(br.readLine());
            if (!expiryDate.isBefore(currentDate))
                gifts++;
        }

        System.out.println(gifts);
    }
}
