package solved.bronze.B1;
import java.io.*;
import java.time.*;

public class B1_10426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String startDateStr = input[0];
        int N = Integer.parseInt(input[1]);

        LocalDate startDate = LocalDate.parse(startDateStr);
        // N-1일 더하면 N번째 날이 됨 (시작한 날도 1일째임)
        LocalDate anniversary = startDate.plusDays(N - 1);

        System.out.println(anniversary);
    }
}
