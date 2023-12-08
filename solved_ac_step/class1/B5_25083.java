package solved_ac_step.class1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B5_25083 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 이스케이프 시퀀스 문제다.
        bw.write("         ,r'\"7"+"\n"); // "를 쌍따옴표 안에서 사용하기 위해 \" 사용.
        bw.write("r`-_   ,'  ,/"+"\n");
        bw.write(" \\. \". L_r'"+"\n"); // \를 사용하기 위해 \\, "를 쌍따옴표 안에서 사용하기 위해 \" 사용.
        bw.write("   `~\\/"+"\n"); // \를 사용하기 위해 \\
        bw.write("      |"+"\n");
        bw.write("      |");

        bw.flush();
        bw.close();
    }



}
