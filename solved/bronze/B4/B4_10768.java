package solved.bronze.B4;
import java.io.*;

public class B4_10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        if(month == 2)
            System.out.println(IsDaySpecial(day));
        else if(month > 2)
            System.out.println("After");
        else
            System.out.println("Before");
    }

    static String IsDaySpecial(int day) {
        if(day == 18)
            return "Special";
        else if(day > 18)
            return "After";
        return "Before";

    }
}
