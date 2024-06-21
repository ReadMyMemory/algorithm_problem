package solved.bronze.B5;

import java.io.*;

public class B5_2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str  = br.readLine();
        // 더 세련되게도 가능했겠지만, 시간이 없어서 걍 조건문 다 걸었다.
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
            bw.write(1.7+"");
        if(str.equals("D+"))
            bw.write(1.3+"");
        if(str.equals("D0"))
            bw.write(1.0+"");
        if(str.equals("D-"))
            bw.write(0.7+"");
        if(str.equals("F"))
            bw.write(0.0+"");

        bw.flush();
        br.close();
        bw.close();
    }


}
