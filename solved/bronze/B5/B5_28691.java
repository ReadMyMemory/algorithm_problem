package solved.bronze.B5;
import java.io.*;

public class B5_28691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        switch (s) {
            case "M":
                System.out.println("MatKor");
                break;
            case "W":
                System.out.println("WiCys");
                break;
            case "C":
                System.out.println("CyKor");
                break;
            case "A":
                System.out.println("AlKor");
                break;
            case "$":
                System.out.println("$clear");
                break;
        }
    }
}
