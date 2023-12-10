package solved;

import java.io.*;

public class B5_2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str  = br.readLine();
        if(str.equals("A+"))
            bw.write(4.3+"");
        if(str.equals("A0"))
            bw.write(4.0+"");
        if(str.equals("A-"))
            bw.write(3.7+"");
        if(str.equals("B+"))
            bw.write(3.3+"");
        if(str.equals("B0"))
            bw.write(3.0+"");
        if(str.equals("B-"))
            bw.write(2.7+"");
        if(str.equals("C+"))
            bw.write(2.3+"");
        if(str.equals("C0"))
            bw.write(2.0+"");
        if(str.equals("C-"))
            bw.write(2.0+"");
    }


}
