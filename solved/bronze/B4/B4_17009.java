package solved.bronze.B4;
import java.io.*;

public class B4_17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int apples3 = Integer.parseInt(br.readLine());
        int apples2 = Integer.parseInt(br.readLine());
        int apples1 = Integer.parseInt(br.readLine());

        int bananas3 = Integer.parseInt(br.readLine());
        int bananas2 = Integer.parseInt(br.readLine());
        int bananas1 = Integer.parseInt(br.readLine());

        int applesScore = (apples3 * 3) + (apples2 * 2) + (apples1 * 1);
        int bananasScore = (bananas3 * 3) + (bananas2 * 2) + (bananas1 * 1);

        if (applesScore > bananasScore) {
            System.out.println("A");
        } else if (applesScore < bananasScore) {
            System.out.println("B");
        } else {
            System.out.println("T");
        }
    }
}
