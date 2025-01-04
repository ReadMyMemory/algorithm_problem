package solved.bronze.B3;
import java.io.*;
public class B3_4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double standard = Double.parseDouble(br.readLine());
        while(true) {
            double value = Double.parseDouble(br.readLine());
            if(value == 999)
                break;
            else {
                bw.write( String.format("%.2f", value - standard) + "\n");
                standard = value;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
