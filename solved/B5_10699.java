package solved;


import java.time.LocalDate;
import java.time.ZoneId;

public class B5_10699 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate seoulTime = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulTime);
    }
}
