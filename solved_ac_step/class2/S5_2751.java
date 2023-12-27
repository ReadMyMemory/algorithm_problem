package solved_ac_step.class2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class S5_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        ArrayList<Integer> list;
        list = new ArrayList<>();

        while(testcase > 0) {
            list.add(Integer.parseInt(br.readLine()));
            testcase--;
        }
        Collections.sort(list);

        for(int a : list)
            bw.write(a+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
