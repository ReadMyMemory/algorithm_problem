package solved.bronze.B3;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B3_10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        System.out.println(list.get(1));
    }
}
